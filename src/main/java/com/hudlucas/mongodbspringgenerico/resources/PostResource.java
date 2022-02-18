package com.hudlucas.mongodbspringgenerico.resources;

import com.hudlucas.mongodbspringgenerico.model.entities.Post;
import com.hudlucas.mongodbspringgenerico.resources.util.URL;
import com.hudlucas.mongodbspringgenerico.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostResource {
	
	@Autowired
	private PostService service;

	@GetMapping("/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post post = service.findById(id);
		
		return ResponseEntity.ok().body(post);
	}

	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findByIdTitle(@RequestParam(value = "text", defaultValue = "") String text) {
		text = URL.decodeParam(text);
		List<Post> list = service.findByTittle(text);

		return ResponseEntity.ok().body(list);
	}
}
