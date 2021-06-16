package com.apirest.octoevents.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.octoevents.entity.Issue;
import com.apirest.octoevents.services.IssueService;

import reactor.core.publisher.Mono;

@RestController
public class IssueController {

	@Autowired
	IssueService issueService;
	
	@PostMapping(value="/issues")
	public Mono<Issue> save(@RequestBody Issue issue){
		return issueService.save(issue);
	}
}
