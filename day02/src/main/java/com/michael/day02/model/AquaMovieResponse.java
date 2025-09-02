package com.michael.day02.model;

import java.util.List;

public class AquaMovieResponse {
    private List<String> genres;
    private List<Movie> movies;

    public AquaMovieResponse() {}

    public List<String> getGenres() { return genres; }
    public void setGenres(List<String> genres) { this.genres = genres; }

    public List<Movie> getMovies() { return movies; }
    public void setMovies(List<Movie> movies) { this.movies = movies; }
    
}
