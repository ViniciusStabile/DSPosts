package DSPosts.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DSPosts.models.DTO.PostDTO;
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
		User entity = getEntityById(id);
		return new UserDTO(entity);
	}

	@Transactional
	public UserDTO insert(UserDTO dto) {
		User entity = new User();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new UserDTO(entity);

	}

	public User getEntityById(String id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
	}

	@Transactional
	public UserDTO update(String id, UserDTO dto) {

		User entity = getEntityById(id);
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new UserDTO(entity);

	}

	public void delete(String id) {
		getEntityById(id);
		repository.deleteById(id);
	}

	public List<PostDTO> getUserPosts(String id){
		User user = getEntityById(id);
		return user.getPosts().stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
	}
	
	
	private void copyDtoToEntity(UserDTO dto, User entity) {
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());

	}

}
