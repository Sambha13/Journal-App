package net.engineersdigest.journal.app.repository;

import net.engineersdigest.journal.app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<User> getUsersForSA() {
//        Query query = new Query();
//        query.addCriteria(Criteria.where("email").exists(true));  // Ensure email exists
//        query.addCriteria(Criteria.where("sentimentAnalysis").is(true));  // Check sentimentAnalysis is true
//        query.addCriteria(Criteria.where("email").ne(null).ne(""));  // Ensure email is not null or empty
//
//        // Use the query object with mongoTemplate.find()
//        return mongoTemplate.find(query, User.class);
        return null;
    }
}
