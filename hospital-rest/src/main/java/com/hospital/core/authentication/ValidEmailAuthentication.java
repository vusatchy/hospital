package com.hospital.core.authentication;

import com.hospital.core.exceptions.InvalidEmailException;
import com.hospital.core.exceptions.InvalidPasswordException;
import com.hospital.core.exceptions.UserAlreadyExistException;
import com.hospital.core.model.User;
import java.util.regex.Pattern;

public class ValidEmailAuthentication extends AuthenticationChain {

    private final static Pattern emailPattern = Pattern
	.compile("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");

    @Override
    public void check(User user) throws InvalidEmailException, InvalidPasswordException, UserAlreadyExistException {
	if (!emailPattern.matcher(user.getMail()).matches()) {
	    throw new InvalidEmailException("Invalid e-mail");
	}
	checkNext(user);
    }
}
