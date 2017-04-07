package com.zyt.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.zyt.Const;
import com.zyt.entity.Document;
import com.zyt.entity.GroupPerson;
import com.zyt.entity.Person;

@Controller
@RequestMapping("/document")
@SessionAttributes(Const.Attr.LOGIN_USER)
public class DocumentController {

    @RequestMapping("/index/{gpid}")
    public String index(@ModelAttribute(Const.Attr.LOGIN_USER) Person loginPerson,int gpid,Model model){
	GroupPerson groupPerson = loginPerson.getGroupPersons().stream().filter(gp->gp.getGpid()==gpid).findFirst().get();
	List<Document> documents = groupPerson.getGroup().getDocuments();
	boolean permitted = groupPerson.isPermitted();
	model.addAttribute(Const.Attr.DOUCMENTS, documents);
	model.addAttribute(Const.Attr.PERMITTED, permitted);
	model.addAttribute(Const.Attr.GPID, groupPerson.getGpid());
	return "document/index";
    }
    
    @RequestMapping("/add/{gpid}")
    public String add(int gpid,Model model){
	model.addAttribute(Const.Attr.GPID, gpid);
	return "document/add";
    }
 
    @RequestMapping(value="/doAdd",method=RequestMethod.POST)
    public String doAdd(@RequestParam("file") CommonsMultipartFile file,@ModelAttribute(Const.Attr.LOGIN_USER) Person loginPerson,int gpid,Model model){
	System.out.println(file);
	return index(loginPerson, gpid, model);
    }
    
}
