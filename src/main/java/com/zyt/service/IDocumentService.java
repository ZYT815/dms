package com.zyt.service;

import com.zyt.entity.Document;

public interface IDocumentService {
	void save(Document document);

	Document selectById(String did);

	void delete(Document document);
}
