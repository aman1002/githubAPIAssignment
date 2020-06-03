package com.telstra.codechallenge.accountsrepos.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class MaxAccountsSizeException extends RuntimeException {

    public MaxAccountsSizeException(String message) {
        super(message);
    }

}
