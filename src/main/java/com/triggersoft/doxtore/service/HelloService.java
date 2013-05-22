package com.triggersoft.doxtore.service;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class HelloService {
	
	
	@Inject
	private EntityManager em; 
	
    public String createHelloMessage(String name) {
        return "Hello " + name + "!";
    }
}
