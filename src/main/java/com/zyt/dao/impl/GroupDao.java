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

	@Override
	public void delete(Group group) {
		getHibernateTemplate().delete(group);
	}

	@Override
	public Group selectByShareId(String shareId) {
		String sharedIdName="shareId";
		String hql=String.format("from Group where shareId = :%s",sharedIdName);
		return (Group) getHibernateTemplate().findByNamedParam(hql, sharedIdName, shareId).stream().findFirst().get();
	}

}
