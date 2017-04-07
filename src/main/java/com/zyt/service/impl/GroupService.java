package com.zyt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyt.dao.IGroupDao;
import com.zyt.entity.Group;
import com.zyt.service.IGroupService;

@Service
public class GroupService implements IGroupService {

    @Autowired
    private IGroupDao groupDao;

    @Override
    public void save(Group group) {
	groupDao.save(group);
    }
}
