package com.triggersoft.doxtore.service.rest;

import java.util.Arrays;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.triggersoft.doxtore.dao.DocumentDao;
import com.triggersoft.doxtore.dao.TagDao;
import com.triggersoft.doxtore.dto.DocumentDTO;
import com.triggersoft.doxtore.dto.TagDTO;
import com.triggersoft.doxtore.entity.Document;
import com.triggersoft.doxtore.entity.Tag;
import com.triggersoft.doxtore.translator.Translator;

@Path("/tags")
@Produces("application/json")
public class TagService {

	@Inject 
	private Translator<Tag, TagDTO> tagTranslator;
	
	
	
	@Inject 
	private TagDao tagDao;
	
	@GET
	@Path("")
	public Response getTags() {

		List<Tag> tags = tagDao.findAll();
		return Response.status(200).entity(tagTranslator.toDTO(tags))
				.build();

	}

	@GET
	@Path("/{id}")
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Response getTagById(@PathParam("id") long id) {
		Tag tag = tagDao.find(id);
		if (tag == null) {
			return Response.status(404).build();
		} else {
			return Response.status(200).entity(tagTranslator.toDTO(tag))
					.build();
		}
			

	}

	@Path("")
	@POST
	public Response saveTag(TagDTO tag) {
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteTagById(@PathParam("id") long id) {

		String result = "";

		return Response.status(200).entity(Arrays.asList(result, result))
				.build();

	}

}
