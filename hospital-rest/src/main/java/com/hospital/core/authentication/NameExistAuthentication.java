package com.hospital.core.authentication;

import com.hospital.core.exceptions.InvalidEmailException;
import com.hospital.core.exceptions.InvalidPasswordException;
import com.hospital.core.exceptions.UserAlreadyExistException;
import com.hospital.core.model.User;
import com.hospital.core.respository.UserRepository;
import java.text.MessageFormat;

public class NameExistAuthentication extends AuthenticationChain {

    private UserRepository userRepository;

    public NameExistAuthentication(UserRepository userRepository) {
	this.userRepository = userRepository;
    }

    @Override
    public void check(User user) throws UserAlreadyExistException, InvalidEmailException, InvalidPasswordException {
	if (userRepository.existsByName(user.getName())) {
	    throw new UserAlreadyExistException(MessageFormat.format("User with name {0} already exit",
		user.getName()));
	}
	checkNext(user);
    }
}
