package com.hudlucas.mongodbspringgenerico.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hudlucas.mongodbspringgenerico.model.entities.User;

@Repository
public interface UserRepositoy extends MongoRepository<User, String>{

}
