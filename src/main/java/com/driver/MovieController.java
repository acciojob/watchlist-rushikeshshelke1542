package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

@RestController
public class MovieController {
    MovieService movieService = new MovieService();

    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {

        String message = movieService.addMovie(movie);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director) {

        String message = movieService.addDirector(director);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie-name") String movie_name, @RequestParam("director-name") String director_name) {
        return new ResponseEntity<>(movieService.addMovieDirectorPair(movie_name, director_name), HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(movieService.getMovieByName(name), HttpStatus.OK);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(movieService.getDirectorByName(name), HttpStatus.OK);
    }

    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<ArrayList<String>> getMoviesByDirectorName(@PathVariable("director") String director) {
        return new ResponseEntity<>(movieService.getMoviesByDirectorName(director), HttpStatus.OK);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<ArrayList<String>> findAllMovies() {
        return new ResponseEntity<>(movieService.findAllMovies(), HttpStatus.OK);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("director-name") String director_name) {
        return new ResponseEntity<>(movieService.deleteDirectorByName(director_name), HttpStatus.OK);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors() {
        return new ResponseEntity<>(movieService.deleteAllDirectors(), HttpStatus.OK);
    }


}
