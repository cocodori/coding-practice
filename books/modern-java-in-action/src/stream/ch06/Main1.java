package stream.ch06;

import stream.Dish;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main1 {
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

//        Long howManyDishes = menu.stream().collect(Collectors.counting());
        long howManyDishes = menu.stream().count();

        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish = menu.stream().collect(Collectors.maxBy(dishCaloriesComparator));
        System.out.println("mostCalorieDish: " + mostCalorieDish);

        // 리스트의 총 칼로리 계산
        Integer totalCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println("totalCalories: " + totalCalories);

        // 평균
        double avgCalories = menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        System.out.println("avgCalories: " + decimalFormat.format(avgCalories));

        //메뉴 요소 수, 칼로리 합계, 평균, 최댓값, 최솟값
        IntSummaryStatistics menuStatistics = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println("menuStatistics: " + menuStatistics);

        //문자열 연결
        String shortMenu = menu.stream().map(Dish::getName).collect(Collectors.joining());
        System.out.println("shortMenu: " + shortMenu);

        String shortMenu2 = menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
        System.out.println("shortMenu2: " + shortMenu2);
    }
}
