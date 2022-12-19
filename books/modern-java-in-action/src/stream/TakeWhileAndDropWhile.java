package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TakeWhileAndDropWhile {

    public static void main(String[] args) {
        List<Dish> specialMenu = Arrays.asList(
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));

        List<Dish> filteredMenu = specialMenu.stream()
                .filter(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());

        System.out.println("filteredMenu: " + filteredMenu);

        // takeWhile은 조건에 맞으면 멈춤
        // takeWhile은 무한 스트림을 포함한 모든 스트림에 Predicate를 적용해 스트림을 슬라이스 할 수 있다.
        List<Dish> sliceMenu1 = specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());

        System.out.println("sliceMenu1: " + sliceMenu1);

        // DropWhile
        // dropWhile()은 Predicate가 처음으로 거짓이 되는 지점까지 발견된 요소를 버린다.
        List<Dish> sliceMenu2 = specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());

        System.out.println("sliceMenu2: " + sliceMenu2);

    }
}
