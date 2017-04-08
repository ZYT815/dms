package com.zyt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.zyt.Const;
import com.zyt.entity.Person;
import com.zyt.service.ILoginService;

@Controller
@RequestMapping("/login")
@SessionAttributes(Const.Attr.LOGIN_USER)
public class LoginController {
	@Autowired
	private ILoginService loginSerivce;

	@ModelAttribute
	public void initModelValue(String username, String password, Model model) {
		model.addAttribute(Const.Attr.Login.USERNAME, username);
		model.addAttribute(Const.Attr.Login.PASSWORD, password);
	}

	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public String doLogin(String username, String password, Model model, ModelMap modelMap) {
		Person login = loginSerivce.login(username, password);
		model.addAttribute(Const.Attr.LOGIN_USER, login);
		return "index";
	}
}
