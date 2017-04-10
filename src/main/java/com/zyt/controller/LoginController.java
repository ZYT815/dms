package com.zyt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.zyt.Const;
import com.zyt.entity.Person;
import com.zyt.service.ILoginService;

@Controller
@RequestMapping("/login")
@SessionAttributes(Const.Attr.LOGIN_USER)
public class LoginController {
	@Autowired
	private ILoginService loginSerivce;

	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public String doLogin(String username, String password, Model model) {
		Person login = loginSerivce.login(username, password);
		model.addAttribute(Const.Attr.LOGIN_USER, login);
		return "index";
	}
	
	@RequestMapping("/logout")
	public String logout(SessionStatus sessionStatus){
		sessionStatus.setComplete();
		return Const.FORWORD+"/";
	}
	
}
