package com.apirest.octoevents.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RepositoryDTO {

	private String name;
	@JsonProperty("full_name")
	private String fullName;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
	
}
