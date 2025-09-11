package com.michael.day02.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michael.day02.model.Movie;
import com.michael.day02.service.ExternalMovieService;
import com.michael.day02.service.MovieService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/movies")
@Tag(name = "Movies", description = "CRUD em memória e integração com AquaScript")
public class MovieController {

    private final MovieService movieService;
    private final ExternalMovieService externalMovieService;

    public MovieController(MovieService movieService, ExternalMovieService externalMovieService) {
        this.movieService = movieService;
        this.externalMovieService = externalMovieService;
    }

    @GetMapping("/external")
    @Operation(summary = "Lista filmes da API externa para Movie")
    public List<Movie> getExternal() {
        return externalMovieService.fetchExternalMovies();
    }

    @GetMapping
    @Operation(summary = "Lista fiilmes do CRUD em memória")
    public List<Movie> list() {
        return movieService.listAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca filme por id (em memória)")
    public Movie get(@PathVariable Long id) {
        return movieService.getById(id);
    }

    @PostMapping
    @Operation(summary = "Cria filmes (em memória)")
    public ResponseEntity<Movie> create(@RequestBody Movie input) {
        return ResponseEntity.ok(movieService.create(input));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza filmes (em memória)")
    public Movie update(@PathVariable Long id, @RequestBody Movie input) {
        return movieService.update(id, input);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove filme (em memória)")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        movieService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
