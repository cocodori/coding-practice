package stream;

import java.util.List;
import java.util.Optional;

public class Reduce {
    public static void main(String[] args) {
        var numbers = List.of(1, 2, 3);

        var sum = numbers.stream().reduce(0, (a,b) -> a + b);
        var sum2 = numbers.stream().reduce(0, Integer::sum);

        System.out.println(sum);
        System.out.println(sum2);

        var product = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(product);

        Optional<Integer> sum3 = numbers.stream().reduce((a,b) -> a+b);
        System.out.println(sum3.get());

        //최댓값
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println(max.get());

        //최솟값
        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        System.out.println(min);
    }
}
