package net.engineersdigest.journal.app.service;

import lombok.extern.slf4j.Slf4j;
import net.engineersdigest.journal.app.entity.User;
import net.engineersdigest.journal.app.repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component

@Slf4j
public class UserService {
    @Autowired
    private UserRepo userRepo;

   private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  // private final static Logger logger = LoggerFactory.getLogger(UserService.class);

    public boolean saveNewUser(User user){
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userRepo.save(user);
            return true;

        } catch (Exception e){
//            logger.info("INfo in the save new user");
            log.error("error occured {}: ", user.getUserName(), e);
            log.trace("Trace");
            log.debug("Debug");
            return false;
        }


    }

    public void saveAdmin(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER","ADMIN"));
        userRepo.save(user);
    }

    public void saveUser(User user){
        userRepo.save(user);
    }


    public List<User> getAll(){
        return userRepo.findAll();
    }
    public Optional<User> findById(String id){
        return userRepo.findById(id);
    }
    public void deleteById(String id){
        userRepo.deleteById(id);
    }

    public User findByUserName(String userName){
       return userRepo.findByUserName(userName);
    }
}
