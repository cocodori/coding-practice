package stream.ch06.collector;

import stream.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
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

        List<Dish> dishes = menu.stream().collect(new ToListCollector<Dish>());
        System.out.println("dishes: " + dishes);
    }

    // Java8에서 takeWhile 흉내내기
    // 정렬된 리스트와 프레디케이트를 인ㅇ수로 받아 프레디케이트를 만족하는 가장 긴 첫 요소 리스트를 반환하도록 직접 takeWhile 구현
    public static <A> List<A> takeWhile(List<A> list, Predicate<A> p) {
        int i = 0;
        for (A item : list) {
            if (!p.test(item)) {
                return list.subList(0, i);
            }
            i++;
        }

        return list;
    }
}
