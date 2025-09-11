import java.net.http.*;
import java.net.URI;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        // Fetch da API
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://www.aquascript.xyz/api/moviesdata.json"))
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Converter JSON para objetos Movie
        ObjectMapper mapper = new ObjectMapper();
        MovieResponse movieResponse = mapper.readValue(response.body(), MovieResponse.class);

        MovieCatalog catalog = new MovieCatalog(movieResponse.getMovies());

        System.out.println("All movies:");
        catalog.printAll();

        System.out.println("\nFiltered by Sci-Fi:");
        catalog.filterByGenre("Sci-Fi").forEach(System.out::println);
    }
    
}
