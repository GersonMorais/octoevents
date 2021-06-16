package com.apirest.octoevents.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Issue {
	
	@Id
	private String id;
	private String action;
	private IssueDTO issue;
	private Long issueId;
	private RepositoryDTO repository;
	
	public Issue(String action, long issueId) {
		this.action = action;
		this.issueId = issueId;
	}
	
	public Issue(Long issueId) {
		this.issueId = issueId;
	}

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
	public Long getIssueId() {
		return issueId;
	}
	public void setIssueId(Long issueId) {
		this.issueId = issueId;
	}
	public RepositoryDTO getRepository() {
		return repository;
	}
	public void setRepository(RepositoryDTO repository) {
		this.repository = repository;
	}
	
	
}
