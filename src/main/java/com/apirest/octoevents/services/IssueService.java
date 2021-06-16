package com.apirest.octoevents.services;

import com.apirest.octoevents.entity.Issue;

import reactor.core.publisher.Mono;

public interface IssueService {

	Mono<Issue> save(Issue issue);
	
}
