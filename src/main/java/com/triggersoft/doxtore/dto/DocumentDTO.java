package com.triggersoft.doxtore.dto;

import java.util.Date;
import java.util.List;

public class DocumentDTO {

	private long id;
	private String title;
	private String notes;
	private Date modifiedDate;
	private String fileToken;
	private List<TagDTO> tags;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public Date getModifiedDate() {
		return modifiedDate;
	}
	
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	public String getFileToken() {
		return fileToken;
	}
	
	public void setFileToken(String fileToken) {
		this.fileToken = fileToken;
	}

	public List<TagDTO> getTags() {
		return tags;
	}

	public void setTags(List<TagDTO> tags) {
		this.tags = tags;
	}
}
