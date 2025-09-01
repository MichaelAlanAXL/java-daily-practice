import java.util.List;

public class Main {
    public static void main(String[] args) {
        MovieCatalog catalog = new MovieCatalog();

        catalog.addMovie(new Movie("The Matrix", 1999, "Sci-Fi", "Wachowski"));
        catalog.addMovie(new Movie("Inception", 2010, "Sci-Fi", "Christopher Nolan"));
        catalog.addMovie(new Movie("Titanic", 1997, "Romance", "James Cameron"));
        catalog.addMovie(new Movie("Gladiator", 2000, "Action", "Ridley Scott"));

        System.out.println("All movies:");
        catalog.getAllMovies().forEach(System.out::println);

        System.out.println("\nFiltered by Sci-Fi:");
        List<Movie> sciFi = catalog.filter(m -> m.getGenre().equalsIgnoreCase("Sci-Fi"));
        sciFi.forEach(System.out::println);
    }


    
}
