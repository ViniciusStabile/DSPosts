package DSPosts.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DSPosts.models.DTO.UserDTO;
import DSPosts.models.entities.User;
import DSPosts.repositories.UserRepository;
import DSPosts.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<UserDTO> findAll() {
		List<User> list = repository.findAll();
		return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());

	}

	public UserDTO findById(String id) {
		Optional<User> user = repository.findById(id);
		User entity = user.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new UserDTO(entity);
	}

}
