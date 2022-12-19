package stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main3 {
    public static void main(String[] args) throws IOException {
        long uniqueWords = 0;
        String filePath = "src/stream/data.txt";
        try (Stream<String> lines = Files.lines(Paths.get(filePath), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();

            System.out.println("uniqueWords: " +  uniqueWords);
        } catch (IOException e) {
            throw e;
        }
    }
}
