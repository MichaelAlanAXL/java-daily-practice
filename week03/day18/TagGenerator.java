
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TagGenerator {
    private final String text;

    public TagGenerator(String filePath) throws IOException {
        text = new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public List<String> getUniqueWordsWithDistinct() {
        return Arrays.stream(text.split("\\W+"))
            .map(String::toLowerCase)
            .distinct()
            .collect(Collectors.toList());
    }

    public Set<String> getUniqueWordsWithSet() {
        return Arrays.stream(text.split("\\W+"))
            .map(String::toLowerCase)
            .collect(Collectors.toCollection(TreeSet::new)); // Tree ordem alfabetica
    }
}
