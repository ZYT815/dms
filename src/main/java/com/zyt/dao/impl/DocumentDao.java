package com.zyt.dao.impl;

import org.springframework.stereotype.Repository;

import com.zyt.dao.IDocumentDao;
import com.zyt.entity.Document;

@Repository
public class DocumentDao extends BaseDao implements IDocumentDao {

	@Override
	public void save(Document document) {
		getHibernateTemplate().save(document);
	}

	@Override
	public void delete(Document document) {
		getHibernateTemplate().delete(document);
	}

	@Override
	public Document selectById(String did) {
		return getHibernateTemplate().get(Document.class, did);
	}

}
