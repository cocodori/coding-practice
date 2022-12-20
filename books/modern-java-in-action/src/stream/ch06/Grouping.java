package stream.ch06;

import stream.Dish;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class Grouping {
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

        Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println("dishesByType: " + dishesByType);

        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream()
                .collect(groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                }));

        System.out.println("dishesByCaloricLevel: " + dishesByCaloricLevel);

        Map<Dish.Type, List<Dish>> caloricDishesByType = menu.stream()
                .collect(groupingBy(
                        Dish::getType,
                        filtering(dish -> dish.getCalories() > 500, toList())));

        System.out.println("caloricDishesByType: " + caloricDishesByType);

        Map<Dish.Type, List<String>> dishNamesByType = menu.stream()
                .collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));
        System.out.println("dishNamesByType: " + dishNamesByType);

        // 다수준 그룹화
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = menu.stream()
                .collect(
                        groupingBy(Dish::getType,
                                groupingBy(dish -> {
                                    if (dish.getCalories() <= 400)
                                        return CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700)
                                        return CaloricLevel.NORMAL;
                                    else
                                        return CaloricLevel.FAT;
                                }))
                );

        System.out.println("dishesByTypeCaloricLevel: " + dishesByTypeCaloricLevel);

        //groupingBy 두 번째 인수로 counting을 전달하여 메뉴에서 요리의 수 를 종류별로 계산
        Map<Dish.Type, Long> typesCount = menu.stream()
                .collect(
                        groupingBy(Dish::getType, counting())
                );
        System.out.println("typesCount: " + typesCount);

        //요리의 종류별 가장 높은 칼로리 음식
        Map<Dish.Type, Optional<Dish>> mostCaloricByType = menu.stream()
                .collect(groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories))));
        System.out.println("mostCaloricByType: " + mostCaloricByType);

        Map<Dish.Type, Dish> mostCaloricByType2 = menu.stream()
                .collect(groupingBy(Dish::getType,
                        collectingAndThen(
                                maxBy(comparingInt(Dish::getCalories)),
                                Optional::get
                        )));

        System.out.println("mostCaloricByType2: " + mostCaloricByType2);

        Map<Dish.Type, Integer> totalCaloriesByType = menu.stream()
                .collect(groupingBy(Dish::getType,
                        summingInt(Dish::getCalories)));

        System.out.println("totalCaloriesByType: " + totalCaloriesByType);

        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType = menu.stream()
                .collect(
                        groupingBy(Dish::getType, mapping(dish -> {
                            if (dish.getCalories() <= 400)
                                return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700)
                                return CaloricLevel.NORMAL;
                            else
                                return CaloricLevel.FAT;
                        }, toSet()))
                );
        System.out.println("caloricLevelsByType: " + caloricLevelsByType);
    }
}
