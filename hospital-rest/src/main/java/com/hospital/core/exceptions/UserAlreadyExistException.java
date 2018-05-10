package com.hospital.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// FIXME: add valid code @Vusach
@ResponseStatus(value= HttpStatus.NOT_FOUND,reason = "User with such name already exist")
public class UserAlreadyExistException extends Exception {

    public UserAlreadyExistException(String message) {
	super(message);
    }
}
