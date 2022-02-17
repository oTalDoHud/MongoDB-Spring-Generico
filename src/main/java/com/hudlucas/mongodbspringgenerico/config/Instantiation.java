package com.hudlucas.mongodbspringgenerico.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import com.hudlucas.mongodbspringgenerico.dto.AuthorDTO;
import com.hudlucas.mongodbspringgenerico.model.entities.Post;
import com.hudlucas.mongodbspringgenerico.repositories.PostRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.hudlucas.mongodbspringgenerico.model.entities.User;
import com.hudlucas.mongodbspringgenerico.repositories.UserRepositoy;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepositoy userRepo;

	@Autowired
	private PostRepositoy postRepo;

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepo.deleteAll();
		postRepo.deleteAll();
		
		User hud = new User("Hudson Lucas Teles Vieira", "Hudson@gmail.com");
		User pp = new User("Peterson Santos", "Peterson@gmail.com");
		User ka = new User("Katharine Araujo", "Katharine@gmail.com");
		User luis = new User("Luis Antonio", "Luis@gmail.com");
		
		userRepo.saveAll(Arrays.asList(hud, pp, ka, luis));

		Post post1 = new Post(sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para SP, abraços!", new AuthorDTO(hud));
		Post post2 = new Post(sdf.parse("21/03/2018"), "Bom dia", "Acordei feliz!", new AuthorDTO(hud));

		postRepo.saveAll(Arrays.asList(post1, post2));
	}

}
