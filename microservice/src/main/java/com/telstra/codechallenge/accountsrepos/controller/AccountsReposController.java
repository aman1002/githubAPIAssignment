package com.telstra.codechallenge.accountsrepos.controller;

import java.util.List;

import com.telstra.codechallenge.accountsrepos.Exceptions.MaxAccountsSizeException;
import com.telstra.codechallenge.accountsrepos.Exceptions.MaxRepositoriesSizeException;
import com.telstra.codechallenge.accountsrepos.dto.AccountDTO;
import com.telstra.codechallenge.accountsrepos.dto.RepositoriesDTO;
import com.telstra.codechallenge.accountsrepos.service.AccountsService;
import com.telstra.codechallenge.accountsrepos.service.RepositoriesService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class AccountsReposController {

    @Autowired
    private AccountsService accountsService;
    
    @Autowired
    private RepositoriesService repositoriesService;
    
    private Integer perPageSize = 100;
    
	/*
	 * Aman Goel(1061001)
	 * Excercise 1 
	 * Finding the list of the highest starred repositories in the last
	 * week
	 */
    
    @GetMapping(path= "/repositories")
    public ResponseEntity<List<RepositoriesDTO>> getRepositories(@RequestParam(name = "page") int page, @RequestParam(name = "numOfRepositories") int numOfRepositories) {
    	log.info("called /repositories with highest number of stars in the last week (last seven days)");
    	
    	if (numOfRepositories > perPageSize)
        	throw new MaxRepositoriesSizeException("Max results that can be fetched per page is: " + perPageSize);
		
    	List<RepositoriesDTO> list =  repositoriesService.getRepositories(page, numOfRepositories);
    	ResponseEntity<List<RepositoriesDTO>> response = new ResponseEntity<List<RepositoriesDTO>>(list, HttpStatus.OK);
    	return response;
    }

    /*
	 * Aman Goel(1061001)
	 * Excercise 2 
	 * Finding the list of oldest users with zero followers
	 */
    
    @GetMapping(path = "/accounts")
    public ResponseEntity<List<AccountDTO>> getAccounts(@RequestParam(name = "page") int page, @RequestParam(name = "numOfAccounts") int numOfAccounts) {
        log.info("called /accounts with zero followers api");
        
        if (numOfAccounts > perPageSize)
        	throw new MaxAccountsSizeException("Max results that can be fetched per page is: " + perPageSize);
        
        List<AccountDTO> list =  accountsService.getAccounts(page, numOfAccounts);
        ResponseEntity<List<AccountDTO>> response = new ResponseEntity<List<AccountDTO>>(list, HttpStatus.OK);
    	return response;
    }

}
