package com.example.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.model.Users;
import com.example.test.repository.UsersRepository;

@RestController
public class UsersController {

	    @Autowired
	    private UsersRepository userRepository;

	    @GetMapping("/getusers")
	    public List<Users> getAllItems() {
	        return userRepository.findAll();
	    }
}
