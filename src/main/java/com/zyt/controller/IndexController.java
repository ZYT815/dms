package com.zyt.controller;

import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.zyt.Const;

@Controller
@SessionAttributes(Const.Attr.LOGIN_USER)
public class IndexController {
	@RequestMapping("/")
	public String index(ModelMap modelMap) {
		if (Objects.isNull(modelMap.get(Const.Attr.LOGIN_USER)))
			return "login";
		else
			return "index";
	}
}
