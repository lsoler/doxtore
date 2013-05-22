package com.triggersoft.doxtore;

import javax.ejb.Stateful;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Stateful
@RequestScoped
public class Resource {
	
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager em;
	
	@Produces
	@RequestScoped
	public EntityManager getEntityManager() {
		return em;
	}
}
