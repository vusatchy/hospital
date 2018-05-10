package com.hospital.core.service;

import com.hospital.core.authentication.AuthenticationResult;
import com.hospital.core.exceptions.InvalidEmailException;
import com.hospital.core.exceptions.InvalidPasswordException;
import com.hospital.core.exceptions.NameDoNotMatch;
import com.hospital.core.exceptions.PassworDoNotMatch;
import com.hospital.core.exceptions.UserAlreadyExistException;
import com.hospital.core.model.User;
import javassist.NotFoundException;


public interface UserService {

    //login
    User findUser(String name, String password) throws NameDoNotMatch, PassworDoNotMatch;

    //register
    User saveUser(User user) throws InvalidPasswordException, UserAlreadyExistException, InvalidEmailException;
}
