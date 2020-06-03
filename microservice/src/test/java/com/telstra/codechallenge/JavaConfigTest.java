package com.telstra.codechallenge;


import com.telstra.codechallenge.accountsrepos.controller.AccountsReposController;
import com.telstra.codechallenge.accountsrepos.service.AccountsService;
import com.telstra.codechallenge.accountsrepos.service.RepositoriesService;

import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class JavaConfigTest {

    @Bean
    public AccountsService accountsTestService() {
        return Mockito.mock(AccountsService.class);
    }
    
    @Bean
    public RepositoriesService repositoriesTestService() {
    	return Mockito.mock(RepositoriesService.class);
    }

    @Bean
    public AccountsReposController accountsTestController() {
        return new AccountsReposController();
    }
}
