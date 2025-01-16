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
        Query query = new Query();

        // Use Criteria where both conditions need to be true
        query.addCriteria(Criteria.where("email").exists(true).and("sentimentAnalysis").is(true));

        // Use the query object with mongoTemplate.find()
        return mongoTemplate.find(query, User.class);
    }

}
