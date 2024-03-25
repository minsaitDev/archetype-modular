package mx.com.santander.hexagonalmodularmaven.entry.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document("entries")
public class EntryEntity {
    @Id
    private String id;
    private String name;
    private byte age;
    private String country;
}
