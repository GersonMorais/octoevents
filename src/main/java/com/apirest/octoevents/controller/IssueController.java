package com.apirest.octoevents.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.octoevents.entity.Issue;
import com.apirest.octoevents.services.IssueService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
}
