package com.zyt.service;

import com.zyt.entity.Group;

public interface IGroupService {
	void save(Group group);

	void delete(Group group);

	Group selectByShareId(String shareId);

	Group get(int gid);

}
