package com.hospital.core.impl;

import com.hospital.core.authentication.AuthenticationChain;
import com.hospital.core.authentication.NameExistAuthentication;
import com.hospital.core.authentication.ValidEmailAuthentication;
import com.hospital.core.authentication.ValidPasswordAuthentication;
import com.hospital.core.exceptions.InvalidEmailException;
import com.hospital.core.exceptions.InvalidPasswordException;
import com.hospital.core.exceptions.NameDoNotMatch;
import com.hospital.core.exceptions.PassworDoNotMatch;
import com.hospital.core.exceptions.UserAlreadyExistException;
import com.hospital.core.model.User;
import com.hospital.core.respository.UserRepository;
import com.hospital.core.service.UserService;
import com.hospital.core.util.EncryptionUtil;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    //login
    @Override
    public User findUser(String name, String password) throws NameDoNotMatch, PassworDoNotMatch {
	User user = userRepository.findByName(name);
	if (user == null) {
	    throw new NameDoNotMatch("User not found");
	}
	if (user.getPassword().equals(EncryptionUtil.encrypt(password))) {
	    return user;
	} else {
	    throw new PassworDoNotMatch("Invalid password");
	}
    }

    //register
    @Override
    public User saveUser(User user) throws InvalidPasswordException, UserAlreadyExistException, InvalidEmailException {
	AuthenticationChain authenticationChain = new NameExistAuthentication(userRepository);
	authenticationChain.linkWith(new ValidEmailAuthentication()).linkWith(
	    new ValidPasswordAuthentication());
	authenticationChain.check(user);
	user.setPassword(EncryptionUtil.encrypt(user.getPassword()));
	return userRepository.save(user);
    }
}
