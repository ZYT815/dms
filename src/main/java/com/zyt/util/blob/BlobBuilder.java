package com.zyt.util.blob;

import java.io.InputStream;
import java.sql.Blob;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.zyt.dao.impl.BaseDao;

@Component
public class BlobBuilder extends BaseDao implements IBlobBuilder {

	@Override
	public Blob builderBlob(byte[] bytes) {
		try (Session session = getHibernateTemplate().getSessionFactory().openSession()) {
			return Hibernate.getLobCreator(session).createBlob(bytes);
		}
	}

	@Override
	public Blob builderBlob(InputStream in, int length) {
		try (Session session = getHibernateTemplate().getSessionFactory().openSession()) {
			return Hibernate.getLobCreator(session).createBlob(in, length);
		}
	}

}
