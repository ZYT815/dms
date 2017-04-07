package com.zyt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyt.dao.impl.PersonDao;
import com.zyt.entity.Person;
import com.zyt.exception.LoginException;
import com.zyt.service.ILoginService;

@Service
public class LoginService implements ILoginService {

    @Autowired
    private PersonDao personDao;

    @Override
    public Person login(String username, String password) {
	Person loginPerson = personDao.selectByUsername(username);
	if (!loginPerson.getPpass().equals(password)) {
	    throw new LoginException();
	}
	return loginPerson;
    }
}
