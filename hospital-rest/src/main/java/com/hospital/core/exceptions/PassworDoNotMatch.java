package com.hospital.core.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Invalid user name or password")
public class PassworDoNotMatch extends Exception {

    public PassworDoNotMatch(String message) {
	super(message);
    }
}
