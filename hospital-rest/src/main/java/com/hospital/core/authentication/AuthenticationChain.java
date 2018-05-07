package com.hospital.core.authentication;

import com.hospital.core.exceptions.InvalidEmailException;
import com.hospital.core.exceptions.InvalidPasswordException;
import com.hospital.core.exceptions.UserAlreadyExistException;
import com.hospital.core.model.User;

public abstract class AuthenticationChain {

    private AuthenticationChain next;

    public AuthenticationChain linkWith(AuthenticationChain next) {
	this.next = next;
	return next;
    }

    public abstract void check(User user) throws UserAlreadyExistException,InvalidEmailException,InvalidPasswordException;

    protected void checkNext(User user) throws UserAlreadyExistException,InvalidEmailException,InvalidPasswordException {
	if (next == null) {
	    return;
	}
	next.check(user);
    }

}
