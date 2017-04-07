package com.zyt.dao.impl;

import org.springframework.stereotype.Repository;

import com.zyt.dao.IGroupDao;
import com.zyt.entity.Group;

@Repository
public class GroupDao extends BaseDao implements IGroupDao {
	@Override
	public void save(Group group) {
		getHibernateTemplate().save(group);
	}
}
