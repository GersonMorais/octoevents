package com.apirest.octoevents.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.apirest.octoevents.entity.Issue;

public interface IssueRepository extends ReactiveMongoRepository<Issue, String> {

}
