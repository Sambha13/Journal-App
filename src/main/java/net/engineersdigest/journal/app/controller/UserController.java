package net.engineersdigest.journal.app.controller;

import net.engineersdigest.journal.app.api.response.WeatherResponse;
import net.engineersdigest.journal.app.entity.User;
import net.engineersdigest.journal.app.repository.UserRepo;
import net.engineersdigest.journal.app.service.UserService;
import net.engineersdigest.journal.app.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    //Web Api Call from React js =>Controller =>Service =>Repository

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private WeatherService weatherService;


    @PutMapping()
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User oldUser = userService.findByUserName(userName);
        oldUser.setUserName(user.getUserName());
        oldUser.setPassword(user.getPassword());

        userService.saveNewUser(oldUser);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUserByName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepo.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @GetMapping
    public ResponseEntity<?> greeting() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       WeatherResponse weatherResponse = weatherService.getWeather("pune");
       String greeting="";
       if(weatherResponse != null) {
          greeting = "Weather feel like " + weatherResponse.getCurrent();
       }

       return new ResponseEntity<>("Hi " + authentication.getName() + greeting,HttpStatus.OK);
    }



}














//  @PutMapping("{userName}")
//  public ResponseEntity<?> updateUser(@RequestBody User user , @PathVariable String userName){
//       User oldUser= userService.findByUserName(userName);
//       if(oldUser != null){
//           oldUser.setUserName(user.getUserName());
//           oldUser.setPassword(user.getPassword());
//
//           userService.saveEntry(oldUser);
//
//       }
//
//       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

//    @GetMapping("{UserName}")
//    public ResponseEntity<?> getAllJournalEntriesOfUser(@PathVariable String userName){
//        User user= userService.findByUserName(userName);
//        List<JournalEntry> all=user.getJournalEntries();
//        if(all !=null && !all.isEmpty()){
//            return new ResponseEntity<>(all, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//
//    }

