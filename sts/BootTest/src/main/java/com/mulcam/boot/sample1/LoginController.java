package com.mulcam.boot.sample1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping("/")
	public String login() {
		System.out.println("login");
		return "login";
	}
}
