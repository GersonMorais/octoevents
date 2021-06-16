package com.apirest.octoevents.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.apirest.octoevents.entity.Issue;
import com.apirest.octoevents.repository.IssueRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class IssueServiceImpl implements IssueService {

	@Autowired
	IssueRepository issueRepository;
	
	@Override
	public Mono<Issue> save(Issue issue) {
		return issueRepository.save(issue);
	}

	@Override
	public Flux<Issue> findByIdIssue(String issueId) {
		Flux<Issue> issue = issueRepository.findByIdIssue(issueId);
		return issue;
	}


}
