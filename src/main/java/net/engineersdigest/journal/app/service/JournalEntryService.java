package net.engineersdigest.journal.app.service;

import net.engineersdigest.journal.app.cache.AppCache;
import net.engineersdigest.journal.app.entity.JournalEntry;
import net.engineersdigest.journal.app.entity.User;
import net.engineersdigest.journal.app.repository.JournalEntryRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepo journalEntryRepo;



    @Autowired
    private UserService userService;


   private final static Logger logger = LoggerFactory.getLogger(JournalEntryService.class);

    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName){
        try {
            User user= userService.findByUserName(userName);
            JournalEntry saved=journalEntryRepo.save(journalEntry);

            user.getJournalEntries().add(saved);
            userService.saveUser(user);
         } catch (Exception e){
            logger.info("Save Entry Error");
            throw new RuntimeException("an error occurred while saving the entry.", e);
        }

    }

   public List<JournalEntry> getAll(){

        return journalEntryRepo.findAll();
   }

    public JournalEntry findById(String id){

        return journalEntryRepo.findById(id).orElse(null);
    }

    @Transactional
    public void deleteById(String userName,String id){
        try {
            User user=userService.findByUserName(userName);
            boolean removed =user.getJournalEntries().removeIf(x -> x.getId().equals(id));
            if(removed){
                userService.saveUser(user);
                journalEntryRepo.deleteById(id);
            }
         } catch (Exception e){
            System.out.println(e);
            throw new RuntimeException("An Error occurred while deleting the journal entry");
        }


    }

}
