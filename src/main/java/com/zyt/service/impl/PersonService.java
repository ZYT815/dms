package com.zyt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyt.dao.IPersonDao;
import com.zyt.entity.Person;
import com.zyt.service.IPersonService;

@Service
public class PersonService implements IPersonService {

	@Autowired
	private IPersonDao personDao;

	@Override
	public Person selectByName(String pname) {
		return personDao.selectByUsername(pname);
	}

}
