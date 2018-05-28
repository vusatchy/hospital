package com.hospital.core.service;

import com.hospital.core.exceptions.InvalidEmailException;
import com.hospital.core.exceptions.InvalidPasswordException;
import com.hospital.core.exceptions.UserAlreadyExistException;
import com.hospital.core.model.User;


public interface UserService {

    User saveUser(String name, String email, String password)
	throws InvalidPasswordException, UserAlreadyExistException, InvalidEmailException;
}
