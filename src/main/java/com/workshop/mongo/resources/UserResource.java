package com.workshop.mongo.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.mongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	
	//@GetMapping também funciona para o paramentro GET
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("1", "Maria", "maria@gmail.com");
		User alex = new User("2", "Alex", "alex@gmail.com");
		User bob = new User("3", "bob", "bob@gmail.com");
		List<User> list = Arrays.asList(maria, alex, bob);
		return ResponseEntity.ok().body(list);
	}

}
