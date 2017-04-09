package com.zyt.controller;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.zyt.Const;
import com.zyt.entity.Group;
import com.zyt.entity.GroupPerson;
import com.zyt.entity.Person;
import com.zyt.service.IGroupPersonService;
import com.zyt.service.IGroupService;

@Controller
@RequestMapping("/group")
@SessionAttributes(Const.Attr.LOGIN_USER)
public class GroupController {

	@Autowired
	private IGroupService groupService;

	@Autowired
	private IGroupPersonService groupPersonService;

	@RequestMapping("/create")
	public String create() {
		return "group/create";
	}

	@RequestMapping(value = "/doCreate", method = RequestMethod.POST)
	public String doCreate(String gname, @ModelAttribute(Const.Attr.LOGIN_USER) Person loginPerson) {
		Group group = new Group();
		group.setGname(gname);
		group.setShareId(UUID.randomUUID().toString().replace("-", ""));

		GroupPerson groupPerson = new GroupPerson();
		groupPerson.setPermitted(true);
		groupPerson.setGroup(group);
		groupPerson.setPerson(loginPerson);

		if (CollectionUtils.isEmpty(loginPerson.getGroupPersons())) {
			loginPerson.setGroupPersons(Stream.of(groupPerson).collect(Collectors.toSet()));
		} else {
			Set<GroupPerson> groupPersons = new HashSet<>(loginPerson.getGroupPersons());
			groupPersons.add(groupPerson);
			loginPerson.setGroupPersons(groupPersons);
		}
		group.setGroupPersons(loginPerson.getGroupPersons());

		groupService.save(group);
		return "index";
	}

	@RequestMapping("/index")
	public String index(@ModelAttribute(Const.Attr.LOGIN_USER) Person loginPerson) {
		return "group/index";
	}

	@RequestMapping("/exit/{gpid}")
	public String exit(@ModelAttribute(Const.Attr.LOGIN_USER) Person loginPerson, @PathVariable String gpid) {
		GroupPerson groupPerson = loginPerson.getGroupPersons().stream().filter(gp -> gp.getGpid().equals(gpid)).findFirst()
				.get();
		groupPersonService.delete(groupPerson);
		loginPerson.setGroupPersons(loginPerson.getGroupPersons().stream().filter(gp->!gp.equals(groupPerson)).collect(Collectors.toSet()));
		return "group/index";
	}
	
	@RequestMapping("/join")
	public String join(){
		return "group/join";
	}
	
	@RequestMapping("/doJoin")
	public String doJoin(@ModelAttribute(Const.Attr.LOGIN_USER)Person loginUser,String shareId){
		groupPersonService.join(loginUser,shareId);
		return "group/index";
	}

}
