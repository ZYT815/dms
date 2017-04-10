package com.zyt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zyt.Const;
import com.zyt.entity.Person;
import com.zyt.service.IRegisterService;

@Controller
public class RegisterController {

	@Autowired
	private IRegisterService registerService;

	@RequestMapping("/register")
	public String register() {
		return "/register";
	}

	@RequestMapping(value = "/doRegister", method = RequestMethod.POST)
	public String doRegister(String username, String password, RedirectAttributes redirectAttributes) {
		Person person = new Person();
		person.setPname(username);
		person.setPpass(password);
		registerService.register(person);
		redirectAttributes.addAttribute(Const.Attr.Login.USERNAME, username);
		redirectAttributes.addAttribute(Const.Attr.Login.PASSWORD, password);
		return Const.FORWORD + "/login/doLogin";
	}

}
