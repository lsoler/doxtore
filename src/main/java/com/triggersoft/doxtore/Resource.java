package com.triggersoft.doxtore;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Resource {
	
	@SuppressWarnings("unused")
	@PersistenceContext
	@Produces
	private EntityManager em;
}
