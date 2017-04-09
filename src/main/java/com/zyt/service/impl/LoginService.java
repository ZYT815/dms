package com.zyt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyt.entity.Person;
import com.zyt.exception.LoginException;
import com.zyt.service.ILoginService;
import com.zyt.service.IPersonService;

@Service
public class LoginService implements ILoginService {

	@Autowired
	private IPersonService personDao;

	@Override
	public Person login(String username, String password) {
		Person loginPerson = personDao.selectByName(username);
		if (!loginPerson.getPpass().equals(password)) {
			throw new LoginException();
		}
		return loginPerson;
	}
}
