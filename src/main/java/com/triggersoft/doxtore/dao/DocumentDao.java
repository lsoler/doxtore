package com.triggersoft.doxtore.dao;

import java.util.List;

import com.triggersoft.doxtore.entity.Document;

public class DocumentDao extends Dao<Document> {

	int PAGE_SIZE = 10;
	public DocumentDao() {
		super(Document.class);
	}
	
	public List<Document> findDocumentsBy(String searchString, int page){
		//TODO: actually search the searchString
		return em.createQuery("from Document d")
		.setFirstResult(page * PAGE_SIZE)
		.setMaxResults(PAGE_SIZE)
		.getResultList();
	}

}
