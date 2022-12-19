package stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveStream {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        // 이런 코드 안 됨. Stream<T>이기 떄문에.
        // menu.stream().map(Dish::getCalories).sum();

        // mapToInt는 Stream이 아닌 IntStream이기 때문에 sum() 사용 가능
        var sum = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println("sum: " + sum);

        // 객체 스트림으로 복원
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();

        OptionalInt optionalInt = menu.stream().mapToInt(Dish::getCalories).max();
        System.out.println("optionalInt:" + optionalInt);

        // 피타고라스의 수 a*a + b*b = c*c
        // a,b만 가지고 c를 구하는 방법
        // Math.sqrt(a*a + b*b) % 1 == 0
        Stream<double[]> pythagoreanTriples = IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .mapToObj(
                                b -> new double[] { a, b, Math.sqrt(a * a + b * b) })
                        .filter(t -> t[2] % 1 == 0));


        pythagoreanTriples.forEach(n -> System.out.println(Arrays.toString(n)));

    }

}
