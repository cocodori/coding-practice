package stream;

import java.util.stream.Stream;

public class InfiniteStream {
    public static void main(String[] args) {
        Stream.iterate(0, n -> n + 2)
            .limit(10)
            .forEach(n -> System.out.println(n));


        Stream.generate(Math::random)
            .limit(5)
            .forEach(System.out::println);
            
    }
}