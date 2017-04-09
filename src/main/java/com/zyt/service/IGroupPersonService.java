package com.zyt.service;

import com.zyt.entity.GroupPerson;
import com.zyt.entity.Person;

public interface IGroupPersonService {
	void delete(GroupPerson groupPerson);

	void join(Person person, String shareId);
}
