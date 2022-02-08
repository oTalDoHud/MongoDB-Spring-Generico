package com.hudlucas.mongodbspringgenerico.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hudlucas.mongodbspringgenerico.model.entities.User;
import com.hudlucas.mongodbspringgenerico.repositories.UserRepositoy;
import com.hudlucas.mongodbspringgenerico.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepositoy userRepo;

	public List<User> findAll() {
		return userRepo.findAll();
	}

	public User findById(String id) {
		Optional<User> user = userRepo.findById(id);

		return user.orElseThrow(()-> new ObjectNotFoundException("Não foi possível encontar o objeto com o ID: " + id));
	}
}
