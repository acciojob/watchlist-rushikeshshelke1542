package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie) {

        return movieRepository.addMovie(movie);
    }

    public String addDirector(Director director) {

        return movieRepository.addDirector(director);
    }

    public Movie getMovieByName(String name) {

        return movieRepository.getMovieByName(name);
    }

    public Director getDirectorByName(String name) {

        return movieRepository.getDirectorByName(name);
    }

    public String addMovieDirectorPair(String movie_name, String director_name) {
        return movieRepository.addMovieDirectorPair(movie_name, director_name);
    }

    public ArrayList<String> getMoviesByDirectorName(String director) {

    return movieRepository.getMoviesByDirectorName(director);
    }

    public ArrayList<String> findAllMovies() {

        return movieRepository.findAllMovies();
    }

    public String deleteDirectorByName(String director_name) {

        return movieRepository.deleteDirectorByName(director_name);
    }

    public String deleteAllDirectors() {

        return movieRepository.deleteAllDirectors();
    }
}
