import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class FileHandling1 {

    public static void main(String[] args) throws IOException {
        String path = "src/mlajava.txt";

        List<String> list = Stream
                .of("hi hello", "simple code", "mla sep batch")
                .map(s -> s + " -success")
                .toList();

        try {
            // Write the list to the file
            Files.write(Paths.get(path), list);

            // Read and process the file
            Stream<String> read = Files.lines(Paths.get(path));
            read.filter(dt -> dt.contains("success"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}