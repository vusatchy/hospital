package com.hospital.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// FIXME: add valid code @Vusach
@ResponseStatus(value= HttpStatus.NOT_FOUND,reason = "Invalid e-mail")
public class InvalidEmailException extends Exception {

    public InvalidEmailException(String message) {
	super(message);
    }
}
