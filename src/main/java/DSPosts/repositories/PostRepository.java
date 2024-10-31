package DSPosts.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import DSPosts.models.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	@Query(" <field>: { $regex: /pattern/, $options: '<options>' } }")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);

}
