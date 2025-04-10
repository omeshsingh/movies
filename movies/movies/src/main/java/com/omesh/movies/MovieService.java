package com.omesh.movies;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public List<Movie> findAllMovies() {
        return repository.findAll();
    }
    public Optional<Movie> findMovieByImdbId(String imdbId) {
        return repository.findMovieByImdbId(imdbId);
    }
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





