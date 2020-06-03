package com.telstra.codechallenge;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MicroServiceMainTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testHealth() throws RestClientException, MalformedURLException {
        ResponseEntity<String> response = restTemplate
                .getForEntity(new URL("http://localhost:" + port + "/actuator/health")
                        .toString(), String.class);
        assertEquals("{\"status\":\"UP\"}", response
                .getBody());
    }
    
    @Test
    public void testAccountsException() throws RestClientException, MalformedURLException {
        ResponseEntity<String> response = restTemplate.getForEntity(new URL("http://localhost:" + port + "/accounts?numOfAccounts=100").toString(), String.class);
        assertEquals(response.getStatusCodeValue(), 412);
    }

    @Test
    public void testAccountsMissingParamException() throws RestClientException, MalformedURLException {
        ResponseEntity<String> response = restTemplate.getForEntity(new URL("http://localhost:" + port + "/accounts").toString(), String.class);
        assertEquals(response.getStatusCodeValue(), 400);
    }

    @Test
    public void testAccountsNotFoundException() throws RestClientException, MalformedURLException {
        ResponseEntity<String> response = restTemplate.getForEntity(new URL("http://localhost:" + port + "/accounts").toString(), String.class);
        assertEquals(response.getStatusCodeValue(), 400);
    }
}
