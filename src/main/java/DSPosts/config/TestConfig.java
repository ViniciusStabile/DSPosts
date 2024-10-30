package DSPosts.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import DSPosts.models.entities.User;
import DSPosts.repositories.PostRepository;
import DSPosts.repositories.UserRepository;
import jakarta.annotation.PostConstruct;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private UserRepository UserRepository;

	@Autowired
	private PostRepository PostRepository;

	@PostConstruct
	public void init() {

		UserRepository.deleteAll();
		PostRepository.deleteAll();

		User maria = new User(null, "Maria", "Maria@gmail.com");
		User alex = new User(null, "Alex", "Alex@gmail.com");
		User marcos = new User(null, "Marcos", "Marcos@gmail.com");

		UserRepository.saveAll(Arrays.asList(maria, alex, marcos));

	}

}
