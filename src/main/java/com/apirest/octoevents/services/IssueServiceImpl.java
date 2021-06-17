package com.apirest.octoevents.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ResponseStatusException;

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
		issue.setNumber(issue.getIssue().getNumber());
		return issueRepository.save(issue);
	}

	@Override
	public Flux<Issue> findByNumber(String number) {
		return issueRepository.findByNumber(number)
				.switchIfEmpty(Flux.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Issue not found")));
	}

}
