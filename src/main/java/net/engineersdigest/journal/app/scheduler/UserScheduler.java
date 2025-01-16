package net.engineersdigest.journal.app.scheduler;

import net.engineersdigest.journal.app.cache.AppCache;
import net.engineersdigest.journal.app.entity.JournalEntry;
import net.engineersdigest.journal.app.entity.User;
import net.engineersdigest.journal.app.repository.UserRepositoryImpl;
import net.engineersdigest.journal.app.service.EmailService;
import net.engineersdigest.journal.app.service.SentimentAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class UserScheduler {
    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepositoryImpl userRepository;

    @Autowired
    private SentimentAnalysisService sentimentAnalysisService;

    @Autowired
    private AppCache appCache;

    //@Scheduled(cron = "0 0/1 * 1/1 * ?")//Run every minutes
    @Scheduled(cron = "0 0 9 ? * SUN")
    public void fetchUserAndSendEmail(){

        List<User> users = userRepository.getUsersForSA();
        for (User user: users){
            List<JournalEntry> journalEntries = user.getJournalEntries();

        List<String> filteredEntries = journalEntries.stream()
                    .filter(Objects::nonNull) // Filter out null journal entries
                    .map(JournalEntry::getContent) // Extract the content of each entry
                    .filter(content -> content != null && !content.isEmpty()) // Ensure content is not null or empty
                    .collect(Collectors.toList());

        String entry = String.join("",filteredEntries);
           String sentiment = sentimentAnalysisService.getSentiment(entry);
           emailService.sendEmail(user.getEmail(),"sentiment for user","sentiment");
        }
    }


    @Scheduled(cron = "0 0/15 * 1/1 * ?")
    public void clearAppcache(){
        appCache.init();

    }

}
