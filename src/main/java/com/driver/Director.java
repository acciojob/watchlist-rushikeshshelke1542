package com.driver;

public class Director {
    private String name;
    private int numberOfMovies;
    private double imdbRating;

    public Director() {
    }

    public Director(String name, int durationInMinutes, double imdbRating) {
        this.name = name;
        this.numberOfMovies = durationInMinutes;
        this.imdbRating = imdbRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurationInMinutes() {
        return numberOfMovies;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.numberOfMovies = durationInMinutes;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }
}
