package com.triggersoft.doxtore.translator;

import com.triggersoft.doxtore.dto.DocumentHeaderDTO;
import com.triggersoft.doxtore.entity.Document;

public class DocumentHeaderTranslator extends Translator<Document, DocumentHeaderDTO> {

	@Override
	public DocumentHeaderDTO toDTO(Document entity) {
		DocumentHeaderDTO dto = new DocumentHeaderDTO();
		dto.setId(entity.getId());
		dto.setTitle(entity.getTitle());
		return dto;
	}

	@Override
	public Document toEntity(DocumentHeaderDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
