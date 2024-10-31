package DSPosts.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import DSPosts.models.DTO.PostDTO;
import DSPosts.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

	@Autowired
	private PostService service;

	@GetMapping
	public ResponseEntity<List<PostDTO>> findAll() {
		List<PostDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<PostDTO> findById(@PathVariable String id) {
		PostDTO post = service.findById(id);
		return ResponseEntity.ok().body(post);
	}

	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<PostDTO>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
		List<PostDTO> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);

	}

	@PostMapping
	public ResponseEntity<PostDTO> insert(@RequestBody PostDTO dto) {
		PostDTO newDto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newDto.getId()).toUri();
		return ResponseEntity.created(uri).body(newDto);

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<PostDTO> update(@PathVariable String id, @RequestBody PostDTO dto) {
		PostDTO newDto = service.update(id, dto);
		return ResponseEntity.ok().body(newDto);

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<PostDTO> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
