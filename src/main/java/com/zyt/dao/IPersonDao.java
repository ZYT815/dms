package com.zyt.dao;

import com.zyt.entity.Person;

public interface IPersonDao {
	Person selectByUsername(String username);

	void save(Person person);
}
