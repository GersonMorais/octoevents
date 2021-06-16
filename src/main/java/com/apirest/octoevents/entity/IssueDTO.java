package com.apirest.octoevents.entity;

public class IssueDTO {

	private String title;
	private Long number;
	private String created_at;
	private String updated_at;
	private String pushed_at;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	public String getPushed_at() {
		return pushed_at;
	}
	public void setPushed_at(String pushed_at) {
		this.pushed_at = pushed_at;
	}
	
	
	
}
