package com.triggersoft.doxtore.translator;

import com.triggersoft.doxtore.dto.DocumentDTO;
import com.triggersoft.doxtore.entity.Document;

public class DocumentTranslator extends Translator<Document, DocumentDTO> {

	@Override
	public DocumentDTO toDTO(Document entity) {
		DocumentDTO dto = new DocumentDTO();
		dto.setId(entity.getId());
		dto.setTitle(entity.getTitle());
		dto.setNotes(entity.getNotes());
		dto.setModifiedDate(entity.getModifiedDate());
		
		return dto;
	}

	@Override
	public Document toEntity(DocumentDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
