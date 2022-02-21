package com.hudlucas.mongodbspringgenerico.repositories;

import com.hudlucas.mongodbspringgenerico.model.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepositoy extends MongoRepository<Post, String>{

    List<Post> findByTitleContainingIgnoreCase(String text);

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTittle(String text);
}
