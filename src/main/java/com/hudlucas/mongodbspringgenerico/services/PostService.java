package com.hudlucas.mongodbspringgenerico.services;

import com.hudlucas.mongodbspringgenerico.dto.UserDTO;
import com.hudlucas.mongodbspringgenerico.model.entities.Post;
import com.hudlucas.mongodbspringgenerico.model.entities.User;
import com.hudlucas.mongodbspringgenerico.repositories.PostRepositoy;
import com.hudlucas.mongodbspringgenerico.repositories.UserRepositoy;
import com.hudlucas.mongodbspringgenerico.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

	@Autowired
	private PostRepositoy postRepo;

	public Post findById(String id) {
		Optional<Post> post = postRepo.findById(id);

		return post.orElseThrow(()-> new ObjectNotFoundException("Não foi possível encontrar o objeto com o ID: " + id));
	}

	public List<Post> findByTittle(String text){
		return postRepo.searchTittle(text);
	}

	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() +24 * 60 * 60 * 1000 );
		return postRepo.fullSearch(text, minDate, maxDate);
	}

}
