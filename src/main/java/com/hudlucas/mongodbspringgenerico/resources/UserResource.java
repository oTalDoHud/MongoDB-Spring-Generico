package com.hudlucas.mongodbspringgenerico.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hudlucas.mongodbspringgenerico.dto.UserDTO;
import com.hudlucas.mongodbspringgenerico.model.entities.User;
import com.hudlucas.mongodbspringgenerico.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> listUser = service.findAll();
		List<UserDTO> listDto = listUser.stream().map(x -> new UserDTO(x))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
		
	}
}
