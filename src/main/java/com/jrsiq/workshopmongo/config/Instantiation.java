package com.jrsiq.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jrsiq.workshopmongo.domain.Post;
import com.jrsiq.workshopmongo.domain.User;
import com.jrsiq.workshopmongo.repository.PostRepository;
import com.jrsiq.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userReposiroty;

	@Autowired
	private PostRepository postReposiroty;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userReposiroty.deleteAll();
		postReposiroty.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("13/06/2018"), "Partiu viagem", "Vou viajar para Curitiba! Abraços!", maria);
		Post post2 = new Post(null, sdf.parse("14/06/2018"), "Bom dia", "Acordei feliz hoje!", maria);
		
		userReposiroty.saveAll(Arrays.asList(maria, alex, bob));
		postReposiroty.saveAll(Arrays.asList(post1, post2));
		
	}

}
