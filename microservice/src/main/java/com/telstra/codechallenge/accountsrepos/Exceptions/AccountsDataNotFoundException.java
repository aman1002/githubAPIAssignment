package com.telstra.codechallenge.accountsrepos.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccountsDataNotFoundException extends RuntimeException {

    public AccountsDataNotFoundException(String message) {
        super(message);
    }

}
