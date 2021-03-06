package com.zyt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyt.dao.IPersonDao;
import com.zyt.entity.Person;
import com.zyt.service.IRegisterService;

@Service
public class RegisterService implements IRegisterService {

	@Autowired
	private IPersonDao personDao;

	@Override
	public void register(Person person) {
		personDao.save(person);
	}

}
