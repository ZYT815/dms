package com.zyt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zyt.Const;
import com.zyt.entity.Person;
import com.zyt.service.ILoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private ILoginService loginSerivce;

	@ModelAttribute
	public void initModelValue(String username, String password, Model model) {
		model.addAttribute(Const.Login.USERNAME, username);
		model.addAttribute(Const.Login.PASSWORD, password);
	}

	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public String doLogin(String username, String password, Model model,HttpSession session) {
		Person login = loginSerivce.login(username, password);
		session.setAttribute("loginUser", login);
		return "index";
	}
}
