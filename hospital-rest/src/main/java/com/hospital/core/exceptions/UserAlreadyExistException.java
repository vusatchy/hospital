package com.hospital.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "User with such name already exist")
public class UserAlreadyExistException extends Exception {

    public UserAlreadyExistException(String message) {
	super(message);
    }
}
