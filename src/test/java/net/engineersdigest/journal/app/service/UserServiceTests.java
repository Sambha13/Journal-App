package net.engineersdigest.journal.app.service;

import net.engineersdigest.journal.app.entity.User;
import net.engineersdigest.journal.app.repository.UserRepo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
   private UserRepo userRepo;

    @ParameterizedTest
    @ValueSource(strings = {
            "ram",
            "vipul",
            "xyzz",
            "bjhvcd"
    })
    @CsvFileSource()
    public void testFindByUserName(String userName){
        User user =userRepo.findByUserName(userName);
        assertNotNull(!user.getJournalEntries().isEmpty(),"failed for:"+userName);

    }
    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,10,12",
            "3,3,6,"
    })
    public void add(int a, int b,  int expected){
        assertEquals(expected,a+b);
    }
}
