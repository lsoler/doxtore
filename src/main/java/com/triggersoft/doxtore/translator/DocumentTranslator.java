package com.triggersoft.doxtore.translator;

import javax.inject.Inject;

import com.triggersoft.doxtore.dto.DocumentDTO;
import com.triggersoft.doxtore.dto.TagDTO;
import com.triggersoft.doxtore.entity.Document;
import com.triggersoft.doxtore.entity.Tag;

public class DocumentTranslator extends Translator<Document, DocumentDTO> {

	@Inject
	Translator<Tag, TagDTO> tagTranslator;
	
	@Override
	public DocumentDTO toDTO(Document entity) {
		DocumentDTO dto = new DocumentDTO();
		dto.setId(entity.getId());
		dto.setTitle(entity.getTitle());
		dto.setNotes(entity.getNotes());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setTags(tagTranslator.toDTO(entity.getTags()));
		return dto;
	}

	@Override
	public Document toEntity(DocumentDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
