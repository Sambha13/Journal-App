package net.engineersdigest.journal.app.repository;

import net.engineersdigest.journal.app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class UserRepositoryImpl {

   @Autowired
   private MongoTemplate mongoTemplate;

    public List<User> getUsersForSA(){
        Query query = new Query();
        query.addCriteria(Criteria.where("userName").is("ram"));
       List<User>  users = mongoTemplate.findAll(User.class);
       return users;

    }
}
