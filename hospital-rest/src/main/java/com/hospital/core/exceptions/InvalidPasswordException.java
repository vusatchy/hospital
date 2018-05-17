package com.hospital.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason = "Invalid password")
public class InvalidPasswordException extends Exception {

    public InvalidPasswordException(String message) {
	super(message);
    }
}
