package com.hospital.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason = "Invalid user name or password")
public class NameDoNotMatch extends Exception {
    public NameDoNotMatch(String message) {
	super(message);
    }
}
