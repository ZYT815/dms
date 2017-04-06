package com.zyt.dao.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class BaseDao extends DaoSupport {
	@Autowired
	protected HibernateTemplate hibernateTemplate;
	
	protected void checkDaoConfig() throws IllegalArgumentException {
		Objects.requireNonNull(hibernateTemplate,()->"hibernateTemplate must not be null");
	}
}
