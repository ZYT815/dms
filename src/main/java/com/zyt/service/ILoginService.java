package com.zyt.service;

import com.zyt.entity.Person;

public interface ILoginService {
	Person login(String username, String password);
}
