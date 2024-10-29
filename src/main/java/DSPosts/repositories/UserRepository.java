package DSPosts.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import DSPosts.models.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
