package net.engineersdigest.journal.app.repository;

import net.engineersdigest.journal.app.entity.ConfigJournalAppEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalAppRepository  extends MongoRepository<ConfigJournalAppEntity, String> {

}
