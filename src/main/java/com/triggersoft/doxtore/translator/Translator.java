package com.triggersoft.doxtore.translator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Translator<E,D> {

	public abstract D toDTO(E entity);
	public abstract E toEntity(D dto);
	
	public List<D> toDTO(Collection<E> entities){
		List<D> result = new ArrayList<D>();
		
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
