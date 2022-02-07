package com.hudlucas.mongodbspringgenerico.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hudlucas.mongodbspringgenerico.model.entities.User;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User hud = new User("1", "Hudson Lucas", "Hudson@gmail.com");
		User pp = new User("2", "Peterson Santos", "Peterson@gmail.com");
		User ka = new User("3", "Katharine Araujo", "Katharine@gmail.com");
		
		List<User> listUser = new ArrayList<>();
		listUser.addAll(Arrays.asList(hud, pp, ka));
		return ResponseEntity.ok().body(listUser);
		
	}
}
