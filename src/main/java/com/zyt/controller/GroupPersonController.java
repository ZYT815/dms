package com.zyt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.zyt.Const;
import com.zyt.entity.Group;
import com.zyt.entity.GroupPerson;
import com.zyt.entity.Person;
import com.zyt.service.IGroupPersonService;
import com.zyt.service.IGroupService;
import com.zyt.service.IPersonService;

@Controller
@RequestMapping("/groupPerson")
@SessionAttributes(Const.Attr.LOGIN_USER)
public class GroupPersonController {

	@Autowired
	private IGroupService groupService;
	@Autowired
	private IGroupPersonService groupPersonService;
	@Autowired
	private IPersonService personService;

	@RequestMapping("/index/{gid}")
	public String index(@PathVariable int gid, Model model) {
		Group group = groupService.get(gid);
		model.addAttribute(Const.Attr.GROUP, group);
		model.addAttribute(Const.Attr.GROUP_PERSON, group.getGroupPersons());
		return "/groupPerson/index";
	}

	@RequestMapping("/fire/{gpid}")
	public String fire(@PathVariable String gpid, @ModelAttribute(Const.Attr.LOGIN_USER) Person person,
			Model model) {
		GroupPerson groupPerson = groupPersonService.get(gpid);
		groupPersonService.delete(groupPerson);
		model.addAttribute(Const.Attr.LOGIN_USER, personService.selectByName(person.getPname()));
		return Const.FORWORD+String.format("/groupPerson/index/%d", groupPerson.getGroup().getGid());
	}

}
