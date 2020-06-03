package com.telstra.codechallenge.accountsrepos.service;

import com.telstra.codechallenge.accountsrepos.Exceptions.AccountsDataNotFoundException;
import com.telstra.codechallenge.accountsrepos.Exceptions.AccountsServiceValidationException;
import com.telstra.codechallenge.accountsrepos.dto.AccountDTO;
import com.telstra.codechallenge.accountsrepos.dto.AccountsResponseDTO;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AccountsService {
	
    @Value("${zeroFollowers.base.url}")
    private String zeroFollowersBaseUrl;
    
    @Autowired
    RestTemplate restTemplate;
    
    /**
     * Exercise 2
     * Returns a list of oldest users with zero followers.
     * Taken from https://api.github.com/search/users?q=followers:0&sort=created_at&order=asc
     *
     * @return - a account list
     * This is for the 2nd Exercise given on the repository bitbucket page
     */
    public List<AccountDTO> getAccounts(int page, int numOfAccounts) {
        log.info("getAccounts with numOfAccounts is" + numOfAccounts);
        AccountsResponseDTO accountsResponseDTO = new AccountsResponseDTO();
        
        String Url = String.format("%s&page=%s&per_page=%s", zeroFollowersBaseUrl, page, numOfAccounts);

        try {
        	accountsResponseDTO = restTemplate.getForObject(Url, AccountsResponseDTO.class);
    	}
    	catch (Exception e) {
    		throw new AccountsServiceValidationException("No valid data found");
    	}
        
    	log.info("Response is" + accountsResponseDTO);
        if (accountsResponseDTO == null) {
            throw new AccountsDataNotFoundException("Error Fetching Data!");
        }

    	return getAccountsDTO(accountsResponseDTO, numOfAccounts);
    }
    
    
    /*
     * This method will return list of account objects from response
     */
    private List<AccountDTO> getAccountsDTO(AccountsResponseDTO response, int numOfAccounts) {

        List<AccountDTO> accountsList = new ArrayList<>();
        accountsList = response.getItems();
        return accountsList;
    }

}
