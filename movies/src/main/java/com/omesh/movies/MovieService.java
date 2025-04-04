package com.omesh.movies;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> singleMovie(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }



    public void testDatabaseConnection() {
        long count = movieRepository.count();
        System.out.println("Total movies in database: " + count);
    }

//    @PostConstruct // Runs after the application starts
//    public void importMovies() {
//        ObjectMapper mapper = new ObjectMapper();
//        TypeReference<List<Movie>> typeReference = new TypeReference<>() {};
//        try (InputStream inputStream = new ClassPathResource("movies.json").getInputStream()) {
//            List<Movie> movies = mapper.readValue(inputStream, typeReference);
//            movieRepository.saveAll(movies);
//            System.out.println("Movies imported successfully!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }




}
