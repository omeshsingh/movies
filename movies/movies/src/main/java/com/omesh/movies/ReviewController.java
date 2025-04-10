package com.omesh.movies;

//import lombok.Setter;
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("api/v1/reviews")
//public class ReviewController {
//
//    @Autowired
//    private ReviewService reviewService;

//    @Autowired
//    private MovieRepository movieRepository;
//
//    @Autowired
//    private ReviewRepository reviewRepository;

//    @PostMapping
//    public ResponseEntity<Review> createReview(@RequestBody Map<String,String> payload){
//        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"),payload.get("imdbId")), HttpStatus.CREATED);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Review> presentReview(){
//        return new ResponseEntity<List<Review>(reviewService.)
//    }

//    @PostMapping
//    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
//        String reviewBody = payload.get("reviewBody");
//        String imdbId = payload.get("imdbId");
//        Review createdReview = reviewService.createReview(reviewBody, imdbId);
//        return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
//    }

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

    @RestController
    @RequestMapping("/api/v1/reviews")
    public class ReviewController {
        @Autowired
        private ReviewService service;

        @PostMapping()
        public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {

            return new ResponseEntity<Review>(service.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.OK);
        }
    }

//    @GetMapping("/{imdbId}")
//    public ResponseEntity<List<Review>> getReviewsByImdbId(@PathVariable String imdbId) {
//        List<Review> reviews = reviewService.getReviewsByImdbId(imdbId);
//        return new ResponseEntity<>(reviews, HttpStatus.OK);
//    }

//    @GetMapping("/{imdbId}")
//    public ResponseEntity<List<Review>> getReviewsForMovie(@PathVariable String imdbId) {
//        Optional<Movie> movieOptional = movieRepository.findMovieByImdbId(imdbId);
//
//        if (movieOptional.isPresent()) {
//            List<Review> reviewIds = movieOptional.get().getReviewIds();
//            List<Review> reviews = reviewRepository.findAllById(reviewIds);
//            return ResponseEntity.ok(reviews);
//        }
//
//        return ResponseEntity.notFound().build();
//    }






