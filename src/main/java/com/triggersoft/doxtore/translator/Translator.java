package com.triggersoft.doxtore.translator;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Translator<E,D> {

	public abstract D toDTO(E entity);
	public abstract E toEntity(D dto);
	
	public Collection<D> toDTO(Collection<E> entities){
		Collection<D> result = new ArrayList<D>();
		
		for(E entity : entities) {
			result.add(toDTO(entity));
		}
		
		return result;
	}
	
	public Collection<E> toEntity(Collection<D> dtos){
		Collection<E> result = new ArrayList<E>();
		
		for(D dto : dtos) {
			result.add(toEntity(dto));
		}
		
		return result;
	}
	
}
