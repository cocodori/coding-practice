package stream.ch06;

import stream.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Reducing {
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

        int totalCalories = menu.stream()
                .collect(Collectors.reducing(0, Dish::getCalories, (i, j) -> i + j));
        System.out.println("totalCalories: " + totalCalories);

        Optional<Dish> mostCalorieDish =
                menu.stream().collect(Collectors.reducing((d1, d2) ->
                                        d1.getCalories() > d2.getCalories() ? d1 : d2));
        System.out.println("mostCalorieDish: " + mostCalorieDish);


    }
}
