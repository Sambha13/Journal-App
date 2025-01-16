package net.engineersdigest.journal.app.cache;

import jakarta.annotation.PostConstruct;
import net.engineersdigest.journal.app.entity.ConfigJournalAppEntity;
import net.engineersdigest.journal.app.repository.ConfigJournalAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {

    @Autowired
    ConfigJournalAppRepository configJournalAppRepository;


    public Map<String, String> app_cache ;
    public  enum keys{
        WEATHER_API
 }

    @PostConstruct //Its Running the after created AppCache Bean class its running time creating
    public void init(){
       app_cache = new HashMap<>();
       List<ConfigJournalAppEntity> all = configJournalAppRepository.findAll();
       for (ConfigJournalAppEntity entity : all){
           app_cache.put(entity.getKey(), entity.getValue());
       }

    }




}
