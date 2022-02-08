package com.hudlucas.mongodbspringgenerico.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.hudlucas.mongodbspringgenerico.model.entities.User;
import com.hudlucas.mongodbspringgenerico.repositories.UserRepositoy;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepositoy userRepo;

	@Override
	public void run(String... args) throws Exception {
		
		userRepo.deleteAll();
		
		User hud = new User("Hudson Lucas Teles Vieira", "Hudson@gmail.com");
		User pp = new User("Peterson Santos", "Peterson@gmail.com");
		User ka = new User("Katharine Araujo", "Katharine@gmail.com");
		User luis = new User("Luis Antonio", "Luis@gmail.com");
		
		userRepo.saveAll(Arrays.asList(hud, pp, ka, luis));
		
	}

}
