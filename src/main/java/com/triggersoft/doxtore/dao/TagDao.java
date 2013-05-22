package com.triggersoft.doxtore.dao;

import java.util.List;

import com.triggersoft.doxtore.entity.Document;
import com.triggersoft.doxtore.entity.Tag;

public class TagDao extends Dao<Tag> {

	public TagDao() {
		super(Tag.class);
	}
	
	public List<Tag> findAll(){
		return em.createQuery("from Tag t").getResultList();
	}

}
