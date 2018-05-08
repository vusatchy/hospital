package com.hospital.core.service;

import com.hospital.core.authentication.AuthenticationChain;
import com.hospital.core.authentication.AuthenticationResult;
import com.hospital.core.authentication.NameExistAuthentication;
import com.hospital.core.authentication.ValidEmailAuthentication;
import com.hospital.core.authentication.ValidPasswordAuthentication;
import com.hospital.core.exceptions.InvalidEmailException;
import com.hospital.core.exceptions.InvalidPasswordException;
import com.hospital.core.exceptions.UserAlreadyExistException;
import com.hospital.core.model.User;
import com.hospital.core.respository.UserRepository;
import com.hospital.core.util.EncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //login
    public User findUser(String name, String password) {
	User user = userRepository.findByName(name);
	if (user == null) {
	    return null;
	}
	if (user.getPassword().equals(EncryptionUtil.encrypt(password))) {
	    return user;
	} else {
	    return null;
	}
    }

    //register
    public AuthenticationResult saveUser(User user) {
	AuthenticationChain authenticationChain = new NameExistAuthentication(userRepository);
	authenticationChain.linkWith(new ValidEmailAuthentication()).linkWith(
	    new ValidPasswordAuthentication());
	try {
	    authenticationChain.check(user);
	} catch (InvalidPasswordException e) {
	    return AuthenticationResult.INVALID_PASSWORD;
	} catch (InvalidEmailException e) {
	    return AuthenticationResult.INVALID_EMAIL;
	} catch (UserAlreadyExistException e) {
	    return AuthenticationResult.INVALID_NAME;
	}
	user.setPassword(EncryptionUtil.encrypt(user.getPassword()));
	userRepository.save(user);
	return AuthenticationResult.SUCCESS;
    }
}
