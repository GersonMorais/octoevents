package com.apirest.octoevents.service;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.apirest.octoevents.entity.Issue;
import com.apirest.octoevents.repository.IssueRepository;
import com.apirest.octoevents.services.IssueServiceImpl;
import com.apirest.octoevents.util.IssueCreator;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
public class IssueServiceTest {

	@InjectMocks
	private IssueServiceImpl issueService;
	
	@Mock
	private IssueRepository issueRepositoryMock;
	
	private Issue issue = IssueCreator.createdIssueSaved();
	
    @BeforeEach
    public void setUp() {
    	BDDMockito.when(issueRepositoryMock.save(IssueCreator.createdIssueSaved()))
    	.thenReturn(Mono.just(issue));
    	
    	BDDMockito.when(issueRepositoryMock.findByNumber(ArgumentMatchers.anyString()))
    	.thenReturn(Flux.just(issue));    	
    }
    
    @Test
    @DisplayName("save an issue when sucessful")
    public void save_CreatesIssue_WhenSucessful() {
    	Issue issueToBeSaved = IssueCreator.createdIssueSaved();
    	
    	StepVerifier.create(issueService.save(issueToBeSaved))
    		.expectSubscription()
    		.expectNext(issue);
    		
    }
    
    @Test
    @DisplayName("findByNumber returns Flux with issues when exists")
    public void findByNumber_ReturnFluxIssue_WhenSucessful() {
   	
    	StepVerifier.create(issueService.findByNumber("1"))
    		.expectSubscription()
    		.expectNext(issue);
    		
    }
    
    @Test
    @DisplayName("findByNumber returns Flux with issues when exists")
    public void findByNumber_ReturnFluxError_WhenEmptyFluxIsReturned() {
    	BDDMockito.when(issueRepositoryMock.findByNumber(ArgumentMatchers.anyString()))
    	.thenReturn(Flux.empty());
   	
    	StepVerifier.create(issueService.findByNumber("1"))
    		.expectSubscription()
    		.expectNext(issue);
    }
}
