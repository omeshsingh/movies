package com.omesh.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
}
//    List<Review> findByImdbId(String imdbId);
//
//    List<Review> findAllById(List<Review> reviewIds);

