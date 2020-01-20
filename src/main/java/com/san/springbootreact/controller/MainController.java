package com.san.springbootreact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.san.springbootreact.model.User;
import com.san.springbootreact.repository.UserRepository;

@Controller
@RequestMapping(path = "/api")
public class MainController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping(path = "/add") 
	public @ResponseBody String addNewUser(@RequestParam String username, @RequestParam String email, @RequestParam String password, @RequestParam String phoneNo) {
		User n = new User();
		n.setUsername(username);
		n.setEmail(email);
		n.setPassword(password);
		n.setPhoneNo(phoneNo);
		userRepository.save(n);
		return "Saved";
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
}
