package com.apirest.octoevents.util;

import com.apirest.octoevents.entity.Issue;
import com.apirest.octoevents.entity.IssueDTO;

public class IssueCreator {
	public static Issue createdIssueSaved() {
		IssueDTO dto = new IssueDTO();
		dto.setNumber("10");
		
		Issue issue = new Issue();
		issue.setAction("open");
		issue.setIssue(dto);
		return issue;
	}
}
