package com.apirest.octoevents.repository;

//import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.apirest.octoevents.entity.Issue;

import reactor.core.publisher.Flux;

@Repository
public interface IssueRepository extends ReactiveMongoRepository<Issue, String> {

	Flux<Issue> findByAction(String action);
	
	Flux<Issue> findByNumber(String number);
}
