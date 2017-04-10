package com.zyt.dao.impl;

import org.springframework.stereotype.Repository;

import com.zyt.dao.IGroupPersonDao;
import com.zyt.entity.GroupPerson;

@Repository
public class GroupPersonDao extends BaseDao implements IGroupPersonDao {
	@Override
	public void delete(GroupPerson groupPerson) {
		getHibernateTemplate().delete(groupPerson);
	}

	@Override
	public void save(GroupPerson groupPerson) {
		getHibernateTemplate().save(groupPerson);
	}

	@Override
	public GroupPerson get(String gpid) {
		return getHibernateTemplate().get(GroupPerson.class, gpid);
	}
}
