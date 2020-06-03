package com.telstra.codechallenge.accountsrepos.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class MaxRepositoriesSizeException extends RuntimeException {
	
	public MaxRepositoriesSizeException(String message) {
		super(message);
	}
}
