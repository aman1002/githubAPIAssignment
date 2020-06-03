package com.telstra.codechallenge;

import com.telstra.codechallenge.accountsrepos.Exceptions.MaxAccountsSizeException;
import com.telstra.codechallenge.accountsrepos.Exceptions.MaxRepositoriesSizeException;
import com.telstra.codechallenge.accountsrepos.controller.AccountsReposController;
import com.telstra.codechallenge.accountsrepos.dto.AccountDTO;
import com.telstra.codechallenge.accountsrepos.dto.RepositoriesDTO;
import com.telstra.codechallenge.accountsrepos.service.AccountsService;
import com.telstra.codechallenge.accountsrepos.service.RepositoriesService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JavaConfigTest.class)
public class AccountsRepositoriesTest {


    @Autowired
    @Qualifier("accountsTestController")
    AccountsReposController accountsController;

    @MockBean
    AccountsService service;
    
    @MockBean
    RepositoriesService repoService;

    List<AccountDTO> accountsDTOList;
    
    List<RepositoriesDTO> repositoriesDTOList;

    @Before
    public void init() {

        accountsDTOList = new ArrayList<>();
        repositoriesDTOList = new ArrayList<>();

        AccountDTO accounts = new AccountDTO((long) 13064110, "mercuryphp", "https://github.com/mercuryphp");
        RepositoriesDTO repositories = new RepositoriesDTO("https://github.com/hediet/vscode-drawio", (long) 3161, "TypeScript",  "This extension integrates Draw.io into VS Code.", "vscode-drawio");

        accountsDTOList.add(accounts);
        repositoriesDTOList.add(repositories);

    }

    @Test
    public void testGetAccountsList() {

        when(this.service.getAccounts(1, 1)).thenReturn(accountsDTOList);

        List<AccountDTO> actualData = accountsController.getAccounts(1, 1).getBody();
        String expectedData = "[{id:13064110, login:mercuryphp, html_url:https://github.com/mercuryphp}]";

        assertEquals(expectedData, actualData.toString());
    }
	  
	  @Test
	  public void testAccountsMaxAccountsSizeException() {
		  Exception exception = assertThrows(MaxAccountsSizeException.class, () -> {
			  accountsController.getAccounts(1, 1000);
			  });
		  String expectedMessage = "Max results that can be fetched";
		  String actualMessage = exception.getMessage();
		  
		  assertTrue(actualMessage.contains(expectedMessage));
	  }
	  
	  @Test
	  public void testGetRepoList() {
		  
		  when(this.repoService.getRepositories(1, 1)).thenReturn(repositoriesDTOList);
		  
		  List<RepositoriesDTO> actualData = accountsController.getRepositories(1, 1).getBody();
		  String expectedData = "[{html_url:https://github.com/hediet/vscode-drawio, watchers_count:3161, language:TypeScript, description:This extension integrates Draw.io into VS Code., name:vscode-drawio}]";
		  
		  assertEquals(expectedData, actualData.toString());
	  }
	  
	  @Test
	  public void testRepoMaxRepoSizeException() {
		  Exception exception = assertThrows(MaxRepositoriesSizeException.class, () -> {
			  accountsController.getRepositories(1, 1000);
			  });
		  String expectedMessage = "Max results that can be fetched";
		  String actualMessage = exception.getMessage();
		  
		  assertTrue(actualMessage.contains(expectedMessage));
	  }

}