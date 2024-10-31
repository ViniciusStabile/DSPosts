package DSPosts.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DSPosts.models.DTO.PostDTO;
import DSPosts.models.entities.Post;
import DSPosts.repositories.PostRepository;
import DSPosts.services.exceptions.ResourceNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public List<PostDTO> findAll() {
		List<Post> list = repository.findAll();
		return list.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());

	}

	public PostDTO findById(String id) {
		Post entity = getEntityById(id);
		return new PostDTO(entity);
	}

	@Transactional
	public PostDTO insert(PostDTO dto) {
		Post entity = new Post();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new PostDTO(entity);

	}

	public Post getEntityById(String id) {
		Optional<Post> post = repository.findById(id);
		return post.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
	}

	@Transactional
	public PostDTO update(String id, PostDTO dto) {

		Post entity = getEntityById(id);
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new PostDTO(entity);

	}

	public void delete(String id) {
		getEntityById(id);
		repository.deleteById(id);
	}

	
	
	private void copyDtoToEntity(PostDTO dto, Post entity) {
		
		entity.setMoment(dto.getMoment());
		entity.setTitle(dto.getTitle());
		entity.setBody(dto.getBody());
		entity.setAuthor(dto.getAuthor());

	}

}
