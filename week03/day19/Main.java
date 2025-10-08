import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Music> playlist = Arrays.asList(
            new Music("Numb", "Linkin Park", 3.05),
            new Music("Bohemia Rhapsody", "Queen", 5.55),
            new Music("Smalls Like Teen Spirit", "Nirvana", 4.30),
            new Music("Hotel California", "Eagles", 6.31),
            new Music("Wonderwall", "Oasis", 4.18)
        );

        // Shuffle
        Collections.shuffle(playlist);

        Supplier<Music> nextSong = () -> playlist.get(new Random().nextInt(playlist.size()));

        System.out.println("Playlist Shuffle Mode On \n");

        Stream.generate(nextSong)
            .limit(5)
            .forEach(song -> System.out.println("Now playing: " + song));

        System.out.println("\nEnd of playlist.");
        
    }
}
