package stream.ch06;

import stream.Dish;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class PartitioningFunction {
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

        Map<Boolean, List<Dish>> partitionedMenu = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian));
        System.out.println("partitionedMenu: " + partitionedMenu);
        System.out.println("vegetarianDishes: " + partitionedMenu.get(true));

        // 위 코드와 같은 결과
        List<Dish> vegetarianDishes = menu.stream().filter(Dish::isVegetarian).collect(toList());
        System.out.println("vegetarianDishes: " + vegetarianDishes);

        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType = menu.stream()
                .collect(
                        partitioningBy(Dish::isVegetarian,
                                groupingBy(Dish::getType)));

        System.out.println("vegetarianDishesByType: " + vegetarianDishesByType);

        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = menu.stream()
                .collect(
                        partitioningBy(Dish::isVegetarian,
                                collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get))
                );
        System.out.println("mostCaloricPartitionedByVegetarian: " + mostCaloricPartitionedByVegetarian);
    }
}
