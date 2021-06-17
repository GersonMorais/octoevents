package com.apirest.octoevents.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Issue {
	
	@Id
	private String id;
	private String action;
	private String number;
	private IssueDTO issue;
	private RepositoryDTO repository;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public IssueDTO getIssue() {
		return issue;
	}
	public void setIssue(IssueDTO issue) {
		this.issue = issue;
	}

	public RepositoryDTO getRepository() {
		return repository;
	}
	public void setRepository(RepositoryDTO repository) {
		this.repository = repository;
	}
	public String getNumber() {
		return getIssue().getNumber();
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
}
