package com.cg.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.UserDetails;
import com.cg.service.UserDetailService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserDetailService service;
	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
	public UserDetails addUser(@RequestBody UserDetails user) {
		return service.addNewUser(user);
	}
	@GetMapping(value = "/id/{id}", consumes = "application/json", produces = "application/json")
	public UserDetails getById(@PathVariable("id") int id) {
		return service.getById(id);
	}
}
