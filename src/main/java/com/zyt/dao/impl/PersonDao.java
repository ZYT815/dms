package com.zyt.dao.impl;

import org.springframework.stereotype.Repository;

import com.zyt.dao.IPersonDao;
import com.zyt.entity.Person;
import com.zyt.exception.LoginException;

@Repository
public class PersonDao extends BaseDao implements IPersonDao {
	@Override
	public Person selectByUsername(String username) {
		String queryString = "from Person where pname = :pname";
		String paramName = "pname";
		return (Person) getHibernateTemplate().findByNamedParam(queryString, paramName, username).stream().findFirst()
				.orElseThrow(() -> new LoginException());
	}

	@Override
	public void save(Person person) {
		getHibernateTemplate().save(person);
	}
}
