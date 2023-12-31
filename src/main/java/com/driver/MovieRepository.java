package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Repository
public class MovieRepository {

    HashMap<String,Movie> movieDB;
    HashMap<String,Director> directorDB;

    HashMap<String, ArrayList<Movie>> directorMovieDB;

    // Last Update - allocating memory in the constructor for the lists :
    public MovieRepository() {
        this.movieDB = new HashMap<>();
        this.directorDB = new HashMap<>();
        this.directorMovieDB = new HashMap<>();
    }

    public String addMovie(Movie movie) {
        movieDB.put(movie.getName(),movie);
        return "Success";
    }

    public String addDirector(Director director) {
        directorDB.put(director.getName(),director);

    return "Success";
    }

    public Movie getMovieByName(String name) {

        return movieDB.get(name);
    }


    public Director getDirectorByName(String name) {

        return directorDB.get(name);
    }

    public String addMovieDirectorPair(String movie_name, String director_name) {
        if(!directorMovieDB.containsKey(director_name))
            directorMovieDB.put(director_name,new ArrayList<Movie>());

        directorMovieDB.get(director_name).add(getMovieByName(movie_name));
        return "Success";
    }


    public List<String> getMoviesByDirectorName(String director) {
        List<String> movieList = new ArrayList<>();

        for(Movie movie :directorMovieDB.get(director)){
            movieList.add(movie.getName());
        }
        return movieList;
    }

    public List<String> findAllMovies(){
        // Efficient way of returning the keySet() of the movie_database :
        return new ArrayList<>(movieDB.keySet());
    }

    public String deleteDirectorByName(String director_name) throws NullPointerException{

        for(Movie movie : directorMovieDB.get(director_name)){
            movieDB.remove(movie.getName());
        }

        directorMovieDB.remove(director_name);
        directorDB.remove(director_name);

        return "Success";
    }

    public String deleteAllDirectors() throws NullPointerException {

        for(String director : directorDB.keySet()){
            for(Movie movie : directorMovieDB.get(director)){
                movieDB.remove(movie.getName());
            }

            directorMovieDB.remove(director);
        }

        directorDB.clear();
   return "Success"; }
}
