import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MovieCatalog {
    private final List<Movie> movies;

    public MovieCatalog() {
        this.movies = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    // Filtrar (Predicate)
    public List<Movie> filter(Predicate<Movie> condition) {
        return movies.stream()
            .filter(condition)
            .collect(Collectors.toList());
    }

    // Return all
    public List<Movie> getAllMovies() {
        return movies;
    }
}