import java.util.List;
import java.util.stream.Collectors;

public class MovieCatalog {
    private final List<Movie> movies;

    public MovieCatalog(List<Movie> movies) {
        this.movies = movies;
    }

    // Return all
    public void printAll() {
        movies.forEach(System.out::println);
    }

    // public void addMovie(Movie movie) {
    //     movies.add(movie);
    // }

    // // Filtrar (Predicate)
    // public List<Movie> filter(Predicate<Movie> condition) {
    //     return movies.stream()
    //         .filter(condition)
    //         .collect(Collectors.toList());
    // }

    public List<Movie> filterByGenre(String genre) {
        return movies.stream()
            .filter(m -> m.getGenres().stream()
                .anyMatch(g -> g.equalsIgnoreCase(genre)))
            .collect(Collectors.toList());
    }
}