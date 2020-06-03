package com.telstra.codechallenge.accountsrepos.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.telstra.codechallenge.accountsrepos.dto.ErrorDetails;

@ControllerAdvice
public class AccountsExceptionHandler {

    @ExceptionHandler(AccountsDataNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleAccountsDataNotFoundException(String message) {
        ErrorDetails errorDetails = new ErrorDetails(message);
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AccountsServiceValidationException.class)
    public final ResponseEntity<ErrorDetails> handleAccountsServiceValidationException(String message) {
        ErrorDetails errorDetails = new ErrorDetails( message);
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(MaxAccountsSizeException.class)
    public final ResponseEntity<ErrorDetails> handleMaxAccountsSizeException(String message) {
        ErrorDetails errorDetails = new ErrorDetails( message);
        return new ResponseEntity<>(errorDetails, HttpStatus.PRECONDITION_FAILED);
    }
    
    @ExceptionHandler(MaxRepositoriesSizeException.class)
    public final ResponseEntity<ErrorDetails> handleMaxRepositoriesSizeException(String message) {
        ErrorDetails errorDetails = new ErrorDetails( message);
        return new ResponseEntity<>(errorDetails, HttpStatus.PRECONDITION_FAILED);
    }
}

