package DSPosts.models.DTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;

import DSPosts.models.entities.Post;
import DSPosts.models.entities.User;

public class UserDTO {

	private String id;
	private String name;
	private String email;

	@DBRef(lazy = true)
	public List<Post> posts = new ArrayList<>();

	public UserDTO() {

	}

	public UserDTO(String id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public UserDTO(User entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.email = entity.getEmail();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Post> getPosts() {
		return posts;
	}

}
