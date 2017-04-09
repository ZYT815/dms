package com.zyt.dao;

import com.zyt.entity.Group;

public interface IGroupDao {
	void save(Group group);

	void delete(Group group);

	Group selectByShareId(String shareId);

}
