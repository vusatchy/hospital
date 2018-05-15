package com.hospital.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason = "Invalid e-mail")
public class InvalidEmailException extends Exception {

    public InvalidEmailException(String message) {
	super(message);
    }
}
