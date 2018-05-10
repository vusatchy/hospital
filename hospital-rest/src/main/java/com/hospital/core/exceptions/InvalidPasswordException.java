package com.hospital.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// FIXME: add valid code @Vusach
@ResponseStatus(value= HttpStatus.NOT_FOUND,reason = "Invalid password")
public class InvalidPasswordException extends Exception {

    public InvalidPasswordException(String message) {
	super(message);
    }
}
