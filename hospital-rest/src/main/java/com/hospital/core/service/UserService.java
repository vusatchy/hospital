package com.hospital.core.service;

import com.hospital.core.authentication.AuthenticationResult;
import com.hospital.core.model.User;


public interface UserService {

    //login
    User findUser(String name, String password);

    //register
    AuthenticationResult saveUser(User user);
}
