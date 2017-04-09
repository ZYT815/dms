package com.zyt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyt.dao.IGroupPersonDao;
import com.zyt.entity.Group;
import com.zyt.entity.GroupPerson;
import com.zyt.entity.Person;
import com.zyt.service.IGroupPersonService;
import com.zyt.service.IGroupService;

@Service
public class GroupPersonService implements IGroupPersonService {

	@Autowired
	private IGroupService groupService;
	@Autowired
	private IGroupPersonDao groupPersonDao;
	
	public synchronized void delete(GroupPerson groupPerson) {
		if(groupPerson.getGroup().getGroupPersons().size()==1){
			groupService.delete(groupPerson.getGroup());
		}
		else{
			groupPersonDao.delete(groupPerson);
		}
	}

	@Override
	public void join(Person person, String shareId) {
		Group group=groupService.selectByShareId(shareId);
		
		GroupPerson groupPerson=new GroupPerson();
		groupPerson.setPerson(person);
		groupPerson.setGroup(group);
		groupPerson.setPermitted(false);
		
		groupPersonDao.save(groupPerson);

		group.getGroupPersons().add(groupPerson);
		person.getGroupPersons().add(groupPerson);
	}

}
