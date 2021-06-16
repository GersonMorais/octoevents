package com.apirest.octoevents.services;

import com.apirest.octoevents.entity.Issue;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IssueService {

	Mono<Issue> save(Issue issue);

	Flux<Issue> findByIdIssue(String issueId);
	
}
