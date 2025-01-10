package net.engineersdigest.journal.app.controller;

import net.engineersdigest.journal.app.cache.AppCache;
import net.engineersdigest.journal.app.entity.User;
import net.engineersdigest.journal.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class adminController {

    @Autowired
    UserService userService;

    @Autowired
    AppCache appCache;

    @GetMapping("/all-users")
    public ResponseEntity<?> getAllUsers(){
        List<User> all = userService.getAll();
        if(all != null && !all.isEmpty()){
            return new ResponseEntity<>(all,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create-admin-user")
    public ResponseEntity<?> createAdmin(@RequestBody User user){
        userService.saveAdmin(user);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/clear-app-cache")
    public void clearAppCache(){
        appCache.init();

    }
}
