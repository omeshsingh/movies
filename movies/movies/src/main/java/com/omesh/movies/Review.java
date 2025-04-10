package com.omesh.movies;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "reviews")
@Data // Lombok will generate getters/setters including getId()
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    private ObjectId id;

    private String body;
    private LocalDateTime created;
    private LocalDateTime updated;

    // Optional constructor (can be removed if using Lombok @AllArgsConstructor)
    public Review(String body, LocalDateTime created, LocalDateTime updated) {
        this.body = body;
        this.created = created;
        this.updated = updated;
    }

    public ObjectId getId() {
        return id;
    }
}
