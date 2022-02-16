package com.hudlucas.mongodbspringgenerico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hudlucas.mongodbspringgenerico.dto.UserDTO;
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

		return user.orElseThrow(()-> new ObjectNotFoundException("Não foi possível encontrar o objeto com o ID: " + id));
	}
	
	public User insert(User user) {
		return userRepo.insert(user);
	}

	public void delete(String id){
		findById(id);
		userRepo.deleteById(id);
	}

	public User update(User user){
		User newUser = findById(user.getId());
		updateData(newUser, user);
		return userRepo.save(newUser);
	}

	private void updateData(User newUser, User user) {
		newUser.setEmail(user.getEmail());
		newUser.setName(user.getName());
	}


	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
}
