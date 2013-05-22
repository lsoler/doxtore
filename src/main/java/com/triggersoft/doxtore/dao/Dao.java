package com.triggersoft.doxtore.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;



public class Dao<T> {
	
	@Inject
	protected EntityManager em;
	
	Class<T> type;
	
	public Dao(Class<T> type)
	{
		this.type = type;
	}
	
	public T find(Object id) {
		return em.find(type, id);
	}
	
	public T save(T entity) {
		return em.merge(entity);
	}
	
	public void delete(T entity) {
		em.remove(entity);
	}

}
