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
import com.hospital.core.security.UserPrincipalImpl;
import com.hospital.core.service.UserService;
import com.hospital.core.util.EncryptionUtil;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
	User user = userRepository.findByName(username);
	if (user == null) {
	    throw new UsernameNotFoundException(username);
	}
	return new UserPrincipalImpl(user);
    }

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