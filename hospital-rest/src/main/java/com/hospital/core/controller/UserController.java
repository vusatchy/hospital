package com.hospital.core.controller;

import com.hospital.core.exceptions.InvalidEmailException;
import com.hospital.core.exceptions.InvalidPasswordException;
import com.hospital.core.exceptions.NameDoNotMatch;
import com.hospital.core.exceptions.PassworDoNotMatch;
import com.hospital.core.exceptions.UserAlreadyExistException;
import com.hospital.core.model.User;
import com.hospital.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public User logIn(@RequestParam("name") String name,
	@RequestParam("password") String password) throws NameDoNotMatch, PassworDoNotMatch {
	return userService.findUser(name, password);
    }

    @PostMapping
    public User register(@RequestParam("name") String name,
	@RequestParam("password") String password,
	@RequestParam("email") String email)
	throws InvalidPasswordException, InvalidEmailException, UserAlreadyExistException {
	return userService.saveUser(name,email,password);
    }

}
