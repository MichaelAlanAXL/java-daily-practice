package com.michael.day02.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.michael.day02.model.AquaMovieResponse;
import com.michael.day02.model.Movie;

@Service
public class ExternalMovieService {
    
    private final RestTemplate restTemplate;

    public ExternalMovieService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Movie> fetchExternalMovies() {
        String url = "https://www.aquascript.xyz/api/moviesdata.json";

        AquaMovieResponse response = restTemplate.getForObject(url, AquaMovieResponse.class);

        if (response == null || response.getMovies() == null) return List.of();
        return response.getMovies();
    }

    public String fetchExternalRawJson() {
        String url = "https://www.aquascript.xyz/api/moviesdata.json";
        return restTemplate.getForObject(url, String.class);
    }
}
