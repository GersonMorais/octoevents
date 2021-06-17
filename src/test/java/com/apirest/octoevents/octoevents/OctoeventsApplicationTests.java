package com.apirest.octoevents.octoevents;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.apirest.octoevents.controller.IssueController;
import com.apirest.octoevents.entity.Issue;
import com.apirest.octoevents.services.IssueServiceImpl;

import reactor.core.publisher.Mono;

//@SpringBootTest
@WebFluxTest(IssueController.class)
class OctoeventsApplicationTests {

	@Autowired
	WebTestClient webTestClient;
	
	@MockBean
	private IssueServiceImpl issueService;
	
	@Test
	public void testCreateIssue() {
		Issue issue = new Issue();
		issue.setAction("open");
//		issue.setIssueId((long) 10);
		Mono<Issue> issueMono = Mono.just(issue); 
		when(issueService.save(issue)).thenReturn(issueMono);
		
		webTestClient.post()
			.uri("/issues")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON)
			.body(Mono.just(issue), Issue.class)
			.exchange()
			.expectStatus().isCreated();
		
	}

}
