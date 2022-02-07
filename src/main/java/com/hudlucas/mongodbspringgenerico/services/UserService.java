package com.hudlucas.mongodbspringgenerico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hudlucas.mongodbspringgenerico.model.entities.User;
import com.hudlucas.mongodbspringgenerico.repositories.UserRepositoy;

@Service
public class UserService {

	@Autowired
	private UserRepositoy userRepo;
	
	public List<User> findAll(){
		return userRepo.findAll();
	}
}
