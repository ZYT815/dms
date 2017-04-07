package com.zyt.controller;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.zyt.Const;
import com.zyt.entity.Group;
import com.zyt.entity.GroupPerson;
import com.zyt.entity.Person;
import com.zyt.service.IGroupService;

@Controller
@RequestMapping("/group")
@SessionAttributes(Const.Attr.LOGIN_USER)
public class GroupController {

    @Autowired
    private IGroupService groupService;

    @RequestMapping("/create")
    public String create() {
	return "group/create";
    }

    @RequestMapping(value="/doCreate",method=RequestMethod.POST)
    public String doCreate(String gname, @ModelAttribute(Const.Attr.LOGIN_USER) Person loginPerson) {
	Group group = new Group();
	group.setGname(gname);

	GroupPerson groupPerson = new GroupPerson();
	groupPerson.setPermitted(true);
	groupPerson.setGroup(group);
	groupPerson.setPerson(loginPerson);

	if (CollectionUtils.isEmpty(loginPerson.getGroupPersons())) {
	    loginPerson.setGroupPersons(Stream.of(groupPerson).collect(Collectors.toList()));
	} else {
	    loginPerson.getGroupPersons().add(groupPerson);
	}
	group.setGroupPersons(loginPerson.getGroupPersons());

	groupService.save(group);
	return "index";
    }

    @RequestMapping("/index")
    public String index(@ModelAttribute(Const.Attr.LOGIN_USER) Person loginPerson){
	return "group/index";
    }

}
