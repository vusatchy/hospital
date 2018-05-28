package com.hospital.core.impl;

import com.hospital.core.authentication.AuthenticationChain;
import com.hospital.core.authentication.NameExistAuthentication;
import com.hospital.core.authentication.ValidEmailAuthentication;
import com.hospital.core.authentication.ValidPasswordAuthentication;
import com.hospital.core.exceptions.InvalidEmailException;
import com.hospital.core.exceptions.InvalidPasswordException;
import com.hospital.core.exceptions.UserAlreadyExistException;
import com.hospital.core.model.Role;
import com.hospital.core.model.User;
import com.hospital.core.respository.UserRepository;
import com.hospital.core.service.UserService;
import com.hospital.core.util.EncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(String name, String email, String password)
	throws InvalidPasswordException, UserAlreadyExistException, InvalidEmailException {
	User user = new User();
	user.setName(name);
	user.setMail(email);
	user.setPassword(password);
	user.setMeetingList(new ArrayList<>());
	user.setRole(Role.PATIENT);
	AuthenticationChain authenticationChain = new NameExistAuthentication(userRepository);
	authenticationChain.linkWith(new ValidEmailAuthentication()).linkWith(
	    new ValidPasswordAuthentication());
	authenticationChain.check(user);
	user.setPassword(EncryptionUtil.encrypt(user.getPassword()));
	return userRepository.save(user);
    }
}
