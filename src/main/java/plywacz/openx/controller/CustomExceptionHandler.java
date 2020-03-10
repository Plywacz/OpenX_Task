package plywacz.openx.controller;
/*
Author: BeGieU
Date: 10.03.2020
*/

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import plywacz.openx.exceptions.RemoteApiException;
import plywacz.openx.exceptions.UrlException;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(value = {RemoteApiException.class})
    public void handleAttemptToDuplicateEntity(RemoteApiException ex) {
        throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, ex.getMessage(), ex);
    }

    @ExceptionHandler(value = {UrlException.class})
    public void handleAccessToNonExistingResource(UrlException ex) {
        throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, ex.getMessage(), ex);
    }
}
