package com.example.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.test.exception.UserNotFoundException;
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
	    
	    @PostMapping(value = "/saveuser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public Users createUser(@RequestBody Users user) {
	        return userRepository.save(user);
	    }
	    
	    @PutMapping("/{id}")
	    public Users updateUser(@PathVariable int id, @RequestBody Users userDetails) {
	        Users user = userRepository.findById(id)
	                                  .orElseThrow(() -> new UserNotFoundException("User not found"));
	        user.setUsername(userDetails.getUsername());
	        user.setPhone_number(userDetails.getPhone_number());
	        user.setEmail(userDetails.getEmail());
	        return userRepository.save(user);
	    }
   
	    @DeleteMapping("/{id}")
	    public String deleteUser(@PathVariable int id) {
	        userRepository.deleteById(id);
	        return "User deleted with id: " + id;
	    }
	    
	    @GetMapping("/{id}")
	    public Users getUserById(@PathVariable int id) {
	        return userRepository.findById(id)
	                .orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found"));
	    }
}
