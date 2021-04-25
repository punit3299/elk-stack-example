package com.elk.controllers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.elk.models.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController {

	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable int id) {

		User user = getUsers().stream().filter(u -> u.getId() == id).findAny().orElse(null);
		if(user!=null) {
			log.info("user found : {}",user);
			return user;
		}
		else {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("User not found with id : {}",id);
			}
			return new User();
		}
		
	}

	@GetMapping("/users")
	public List<User> getUsers() {

		return Stream.of(new User(1, "Punit"), new User(2, "Mayank"), new User(3, "Cp")).collect(Collectors.toList());

	}

}
