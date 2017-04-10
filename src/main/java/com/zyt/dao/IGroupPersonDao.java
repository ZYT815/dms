package com.zyt.dao;

import com.zyt.entity.GroupPerson;

public interface IGroupPersonDao {

	void delete(GroupPerson groupPerson);

	void save(GroupPerson groupPerson);

	GroupPerson get(String gpid);

}
