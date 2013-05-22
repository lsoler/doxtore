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
import com.triggersoft.doxtore.dto.DocumentDTO;
import com.triggersoft.doxtore.dto.DocumentHeaderDTO;
import com.triggersoft.doxtore.entity.Document;
import com.triggersoft.doxtore.translator.Translator;

@Path("/documents")
@Produces("application/json")
public class DocumentService {

	@Inject 
	private Translator<Document, DocumentHeaderDTO> headerTranslator;
	
	@Inject 
	private Translator<Document, DocumentDTO> documentTranslator;
	
	@Inject 
	private DocumentDao documentDao;
	
	@GET
	@Path("")
	public Response getDocuments(@QueryParam("searchString") String searchString, 
								@QueryParam("page") int page) {

		List<Document> documents = documentDao.findDocumentsBy(searchString, page);
		return Response.status(200).entity(headerTranslator.toDTO(documents))
				.build();

	}

	@GET
	@Path("/{id}")
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Response getDocumentById(@PathParam("id") long id) {
		Document document = documentDao.find(id);
		if (document == null) {
			return Response.status(404).build();
		} else {
			return Response.status(200).entity(documentTranslator.toDTO(document))
					.build();
		}
			

	}

	@Path("")
	@POST
	public Response saveDocument(DocumentDTO document) {
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteDocumentById(@PathParam("id") long id) {

		String result = "";

		return Response.status(200).entity(Arrays.asList(result, result))
				.build();

	}

}
