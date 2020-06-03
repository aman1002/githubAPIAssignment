package com.telstra.codechallenge.accountsrepos.service;

import com.telstra.codechallenge.accountsrepos.Exceptions.AccountsDataNotFoundException;
import com.telstra.codechallenge.accountsrepos.Exceptions.AccountsServiceValidationException;
import com.telstra.codechallenge.accountsrepos.dto.RepositoriesDTO;
import com.telstra.codechallenge.accountsrepos.dto.RepositoriesResponseDTO;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class RepositoriesService {
    
	@Value("${githubApi.base.url}")
	private String githubApiBAseUrl;
	
	@Autowired
	RestTemplate restTemplate;
    
    private String maxStarredRepoBaseUrl;

    /**
     * Exercise 1
     * Returns a list of the highest starred repositories in the last week.
     * 
     * @return - a account list
     * This is for the 1st Exercise given on the repository bitbucket page
     */
    public List<RepositoriesDTO> getRepositories(int page, int numOfRepositories) {
    	log.info("get maximum starred repositories of last week with numOfRepositories is: " + numOfRepositories);
    	RepositoriesResponseDTO repoResponseDTO = new RepositoriesResponseDTO();
    	
    	LocalDate startDate = LocalDate.now().minusDays(7);
    	LocalDate endDate = LocalDate.now().minusDays(1);
    	
		/*
		 * URL used to hit endpoint of Github search repositories API
		 * https://api.github.com/search/repositories?q=created:YYYY-MM-DD..YYYY-MM-DD&
		 * sort=stars&order=desc
		 */
    	
    	maxStarredRepoBaseUrl = String.format("%srepositories?q=created:%s..%s&sort=stars&order=desc&page=%s&per_page=%s", githubApiBAseUrl, startDate, endDate, page, numOfRepositories);
    	
    	try {
    		repoResponseDTO = restTemplate.getForObject(maxStarredRepoBaseUrl, RepositoriesResponseDTO.class);
    	}
    	catch (Exception e) {
    		throw new AccountsServiceValidationException("No valid data found");
    	}
        
    	log.info("Response is" + repoResponseDTO);
        if (repoResponseDTO == null) {
            throw new AccountsDataNotFoundException("Error Fetching Data!");
        }

    	return getRepositoriesDTO(repoResponseDTO, numOfRepositories);
    }

    
    /*
	 * This method will return list of max starred repositories objects from
	 * response
	 */
    private List<RepositoriesDTO> getRepositoriesDTO(RepositoriesResponseDTO response, int numOfRepositories) {

        List<RepositoriesDTO> repositoriesList = new ArrayList<>();
        repositoriesList = response.getItems();
        return repositoriesList;
    }
}
