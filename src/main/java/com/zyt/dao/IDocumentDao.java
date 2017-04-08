package com.zyt.dao;

import com.zyt.entity.Document;

public interface IDocumentDao {

	void save(Document document);

	void delete(Document document);

	Document selectById(String did);

}
