package com.apirest.octoevents.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.apirest.octoevents.entity.Issue;
import com.apirest.octoevents.services.IssueService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Api(value="API REST OctoEvents")
@CrossOrigin(origins = "*")
public class IssueController {

	@Autowired
	IssueService issueService;
	
	@PostMapping(value="/issues")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value="Save the issues from the repository")
	public Mono<Issue> save(@RequestBody Issue issue){
		return issueService.save(issue);
	}
	
	@ApiOperation(value="List issues by number")
	@GetMapping(value="/issues/{number}/events")
	public Flux<Issue> findByNumber(@PathVariable String number){
		return issueService.findByNumber(number);
	}
	
}
