package DSPosts.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import DSPosts.models.entities.User;
import DSPosts.repositories.UserRepository;
import jakarta.annotation.PostConstruct;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void init() {

		repository.deleteAll();

		User maria = new User(null, "Maria", "Maria@gmail.com");
		User alex = new User(null, "Alex", "Alex@gmail.com");
		User marcos = new User(null, "Marcos", "Marcos@gmail.com");
		
		repository.saveAll(Arrays.asList(maria,alex,marcos));

	}

}
