package com.hudlucas.mongodbspringgenerico.repositories;

import com.hudlucas.mongodbspringgenerico.model.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepositoy extends MongoRepository<Post, String>{

}
