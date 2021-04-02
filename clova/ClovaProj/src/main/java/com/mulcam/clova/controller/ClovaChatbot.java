package com.mulcam.clova.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import android.util.Base64;

@RestController
public class ClovaChatbot {
	@RequestMapping(value="/chatbot")
	public ResponseEntity<String> chatbotTest(@RequestParam(value="order", required = false) String order ) {
		System.out.println(order);
		String voiceMessage = order;
		String chatbotMessage = "";

		try {
			String apiURL = "https://7a47b2dd7e4f474c9f005449eea5498a.apigw.ntruss.com/custom/v1/4276/a8a51f6f1e4a8693f121437ebf16d32d7b8983bdaf406152a48b2770972fd228";
			String secretKey = "aEhDS29LcU1CeW9lcWNOc1Z3ektpTUNNaHFUakJkdEc=";
			URL url = new URL(apiURL);

			String message = getReqMessage(voiceMessage);
			System.out.println("##" + message);

			String encodeBase64String = makeSignature(message, secretKey);

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json;UTF-8");
			con.setRequestProperty("X-NCP-CHATBOT_SIGNATURE", encodeBase64String);

			// post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.write(message.getBytes("UTF-8"));
			wr.flush();
			wr.close();
			int responseCode = con.getResponseCode();

			BufferedReader br;

			if (responseCode == 200) { // Normal call
				System.out.println(con.getResponseMessage());

				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String decodedString;
				while ((decodedString = in.readLine()) != null) {
					chatbotMessage = decodedString;
				}
				// chatbotMessage = decodedString;
				in.close();

			} else { // Error occurred
				chatbotMessage = con.getResponseMessage();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println(chatbotMessage);
		
		JSONObject jsonMessage =new JSONObject(chatbotMessage);
	    JSONArray bubbles= (JSONArray)jsonMessage.getJSONArray("bubbles");
	    JSONObject bubble = (JSONObject)bubbles.getJSONObject(0);
	    JSONObject data = (JSONObject)bubble.getJSONObject("data");
	    String description = (String)data.getString("description");
	    JSONArray slot= bubble.getJSONArray("slot");
	    
	    boolean end = true;
	    for(int i=0; i<slot.length(); i++) {
	    	JSONObject obj = (JSONObject)slot.getJSONObject(i);
	    	String value = obj.getString("value");
	    	end = end && !value.equals("");
	    }
	    
	    JSONObject pizza = new JSONObject();
		pizza.put("description", description);
		pizza.put("end", end);
		ResponseEntity entity = new ResponseEntity<String>(pizza.toString(), HttpStatus.OK);
		return entity;
		//return chatbotMessage;
	}
	public static String makeSignature(String message, String secretKey) {

		String encodeBase64String = "";

		try {
			byte[] secrete_key_bytes = secretKey.getBytes("UTF-8");

			SecretKeySpec signingKey = new SecretKeySpec(secrete_key_bytes, "HmacSHA256");
			Mac mac = Mac.getInstance("HmacSHA256");
			mac.init(signingKey);

			byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
			encodeBase64String = Base64.encodeToString(rawHmac, Base64.NO_WRAP);

			return encodeBase64String;

		} catch (Exception e) {
			System.out.println(e);
		}

		return encodeBase64String;

	}

	public static String getReqMessage(String voiceMessage) {

		String requestBody = "";

		try {

			JSONObject obj = new JSONObject();

			long timestamp = new Date().getTime();

			System.out.println("##" + timestamp);

			obj.put("version", "v2");
			obj.put("userId", "U47b00b58c90f8e47428af8b7bddc1231heo2");
			// => userId is a unique code for each chat user, not a fixed value, recommend
			// use UUID. use different id for each user could help you to split chat history
			// for users.

			obj.put("timestamp", timestamp);

			JSONObject bubbles_obj = new JSONObject();

			bubbles_obj.put("type", "text");

			JSONObject data_obj = new JSONObject();
			data_obj.put("description", voiceMessage);

			bubbles_obj.put("type", "text");
			bubbles_obj.put("data", data_obj);

			JSONArray bubbles_array = new JSONArray();
			bubbles_array.put(bubbles_obj);

			obj.put("bubbles", bubbles_array);
			obj.put("event", "send");

			requestBody = obj.toString();

		} catch (Exception e) {
			System.out.println("## Exception : " + e);
		}

		return requestBody;

	}
}
