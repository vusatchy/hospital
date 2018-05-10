package com.hospital.core.authentication;

import com.hospital.core.exceptions.InvalidEmailException;
import com.hospital.core.exceptions.InvalidPasswordException;
import com.hospital.core.exceptions.UserAlreadyExistException;
import com.hospital.core.model.User;
import java.util.regex.Pattern;

public class ValidPasswordAuthentication extends AuthenticationChain {

    private final static Pattern passwordPattern = Pattern
	.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$");

    @Override
    public void check(User user) throws InvalidPasswordException, InvalidEmailException, UserAlreadyExistException {
	if (!passwordPattern.matcher(user.getPassword()).matches()) {
	    throw new InvalidPasswordException("Invalid password");
	}
	 checkNext(user);
    }
}
