package net.engineersdigest.journal.app.repository;

import net.engineersdigest.journal.app.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User,String> {
    User findByUserName(String userName);
    void deleteByUserName(String userName);
}
