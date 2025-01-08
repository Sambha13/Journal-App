package net.engineersdigest.journal.app.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Document(collection="JournalEntry")
@Data
@NoArgsConstructor
public class JournalEntry {
     @Id
     private String id;
     private String title;
     private String content;
}
