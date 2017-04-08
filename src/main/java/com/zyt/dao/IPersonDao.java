package com.zyt.dao;

import com.zyt.entity.Person;

public interface IPersonDao {
	public Person selectByUsername(String username);
}
