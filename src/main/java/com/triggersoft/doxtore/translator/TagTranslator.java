package com.triggersoft.doxtore.translator;

import com.triggersoft.doxtore.dto.TagDTO;
import com.triggersoft.doxtore.entity.Tag;

public class TagTranslator extends Translator<Tag, TagDTO> {

	@Override
	public TagDTO toDTO(Tag entity) {
		TagDTO dto = new TagDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		return dto;
	}

	@Override
	public Tag toEntity(TagDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
