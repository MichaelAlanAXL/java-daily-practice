package com.michael.day02.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.michael.day02.model.Movie;

@Service
public class MovieService {
    private final Map<Long, Movie> store = new ConcurrentHashMap<>();
    private final AtomicLong seq = new AtomicLong(1000);

    public List<Movie> listAll() {
        return new ArrayList<>(store.values());
    }

    public Movie getById(Long id) {
        Movie m = store.get(id);
        if (m == null) throw new NoSuchElementException("Movie not found: " + id);
        return m;
    }

    public Movie create(Movie input) {
        Long id = seq.incrementAndGet();
        Movie m = new Movie(
            id,
            input.getTitle(),
            input.getYear(),
            input.getRuntime(),
            input.getGenres(),
            input.getDirector(),
            input.getActors(),
            input.getPlot(),
            input.getPosterUrl()
        );
        store.put(id, m);
        return m;
    }

    public Movie update(Long id, Movie input) {
        Movie existing = getById(id);
        if (input.getTitle() != null) existing.setTitle(input.getTitle());
        if (input.getGenres() != null) existing.setGenres(input.getGenres());
        if (input.getYear() != null) existing.setYear(input.getYear());
        return existing;
    }

    public void delete(Long id) {
        if (store.remove(id) == null) throw new NoSuchElementException("Movie not found: " + id);
    }
}
