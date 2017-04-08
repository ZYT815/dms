package com.zyt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyt.dao.IDocumentDao;
import com.zyt.entity.Document;
import com.zyt.service.IDocumentService;

@Service
public class DocumentService implements IDocumentService {

	@Autowired
	private IDocumentDao documentDao;

	@Override
	public void save(Document document) {
		documentDao.save(document);
	}

	@Override
	public Document selectById(String did) {
		return documentDao.selectById(did);
	}

	@Override
	public void delete(Document document) {
		documentDao.delete(document);
	}

}
