package com.telstra.codechallenge.accountsrepos.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AccountsServiceValidationException extends RuntimeException {

    public AccountsServiceValidationException(String message) {
        super(message);
    }
}
