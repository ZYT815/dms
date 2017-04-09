package com.zyt.util.generator;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.zyt.entity.GroupPerson;

public class GroupPersonIdCombinationGenernaterStrategy implements IdentifierGenerator{
		public Serializable generate(SharedSessionContractImplementor session, Object object)
				throws HibernateException {
			GroupPerson groupPerson=(GroupPerson) object;
			return String.format("%d_%d", groupPerson.getGroup().getGid(),groupPerson.getPerson().getPid());
		}
	}