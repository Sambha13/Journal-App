package net.engineersdigest.journal.app.cache;

import jakarta.annotation.PostConstruct;
import net.engineersdigest.journal.app.entity.ConfigJournalAppEntity;
import net.engineersdigest.journal.app.repository.ConfigJournalAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class AppCache {

    @Autowired
    ConfigJournalAppRepository configJournalAppRepository;
    public Map<String, String> APP_CACHE = new ConcurrentHashMap<>();

    @PostConstruct
    public void init(){
       List<ConfigJournalAppEntity> all = configJournalAppRepository.findAll();
       for (ConfigJournalAppEntity entity : all){
           APP_CACHE.put(entity.getKey(), entity.getValue());
       }

    }


}
