package com.mulcam.bank;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mulcam.bean.Account;

@Controller
public class AccountController {
	
	@RequestMapping(value="/makeaccount", method=RequestMethod.GET)
	public String makeAccount(Model model) {
		model.addAttribute("page", "makeaccount_form");
		return "template";
	}
	
	@RequestMapping(value="/makeaccount", method=RequestMethod.POST)
	public String makeAccount(HttpServletRequest request, Model model) {
		try {
			model.addAttribute("page", "makeaccount_form");
			Account acc = new Account();
			acc.setId(request.getParameter("id"));
			acc.setName(request.getParameter("name"));
			acc.setBalance(Integer.parseInt(request.getParameter("balance")));
			acc.setSect(request.getParameter("sect"));
			acc.setGrade(request.getParameter("grade"));
			
			HttpSession session = request.getSession();
			session.setAttribute(request.getParameter("id"),acc);
			
			model.addAttribute("page", "makeaccount_success");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("err", "계좌 개설 실패");
			model.addAttribute("page","err");
		}
		return "template";
	}
	
	@RequestMapping(value="/deposit", method=RequestMethod.GET)
	public String deposit(Model model) {
		model.addAttribute("page", "deposit_form");
		return "template";
	}

	@RequestMapping(value="/deposit", method=RequestMethod.POST)
	public String deposit(HttpServletRequest request, Model model) {
		try {
			String id = request.getParameter("id");
			int money = Integer.parseInt(request.getParameter("money"));
			
			HttpSession session = request.getSession();
			Account acc = (Account)session.getAttribute(id);
			if (acc==null) {
				model.addAttribute("err", "계좌번호 오류");
				model.addAttribute("page","err");
			} else {
				acc.deposit(money);
				// 입금 정보를 알려주기 위해 값을 넘겨줌
				model.addAttribute("id", id);
				model.addAttribute("money", money);
				model.addAttribute("page", "deposit_success");
			}
		} catch (Exception e) {
			model.addAttribute("err", "입금 오류");
			model.addAttribute("page", "err");
		}
		return "template";
	}
	
	@RequestMapping(value="/withdraw", method=RequestMethod.GET)
	public String withdraw(Model model) {
		model.addAttribute("page", "withdraw_form");
		return "template";
	}
	
	@RequestMapping(value="/withdraw", method=RequestMethod.POST)
	public String withdraw(HttpServletRequest request, Model model) {
		try {
			String id = request.getParameter("id");
			int money = Integer.parseInt(request.getParameter("money"));
			
			HttpSession session = request.getSession();
			Account acc = (Account)session.getAttribute(id);
			if (acc==null) {
				model.addAttribute("err", "계좌번호 오류");
				model.addAttribute("page","err");
			} else {
				acc.withdraw(money);
				// 출금 정보를 알려주기 위해 값을 넘겨줌
				model.addAttribute("id", id);
				model.addAttribute("money", money);
				model.addAttribute("page", "withdraw_success");
			}
		} catch (Exception e) {
			model.addAttribute("err", "출금 오류");
			model.addAttribute("page", "err");
		}
		return "template";
	}
	
	@RequestMapping(value="/accinfo", method=RequestMethod.GET)
	public String accinfo(Model model) {
		model.addAttribute("page", "accinfo_form");
		return "template";
	}

	@RequestMapping(value="/accinfo", method=RequestMethod.POST)
	public ModelAndView accinfo(HttpServletRequest request, Model model) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			String id = request.getParameter("id");
			HttpSession session = request.getSession();
			Account acc = (Account)session.getAttribute(id);
			if (acc==null) {
				modelAndView.addObject("err", "계좌오류");
				modelAndView.addObject("page", "err");
			} else {
				modelAndView.addObject("acc", acc);
				modelAndView.addObject("page", "accinfo_success");
			}
		} catch (Exception e) {
			modelAndView.addObject("err", "계좌조회 오류");
			modelAndView.addObject("age", "err");
		}
		modelAndView.setViewName("template");
		return modelAndView;
	}
	
	@RequestMapping(value="/allaccinfo", method=RequestMethod.GET)
	public String allaccinfo(Model model) {
		model.addAttribute("page", "allaccinfo_form");
		return "template";
	}
	
	@RequestMapping(value="/allaccinfo", method=RequestMethod.POST)
	public ModelAndView allAccInfo(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			ArrayList<Account> accs = new ArrayList<>();
			HttpSession session = request.getSession();
			Enumeration<String> it = session.getAttributeNames();
			while (it.hasMoreElements()) {
				String name = it.nextElement();
				Object obj = session.getAttribute(name);
				if (obj instanceof Account) {
					accs.add((Account)obj);
				}
			}
			modelAndView.addObject("accs", accs);
			modelAndView.addObject("page", "allaccinfo_success");
		} catch (Exception e) {
			modelAndView.addObject("err", "전체계좌조회 오류");
			modelAndView.addObject("age", "err");
		}
		modelAndView.setViewName("template");
		return modelAndView;
	}
}
