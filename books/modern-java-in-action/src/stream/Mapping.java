package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mapping {
    public static void main(String[] args) {
        List<String> words = List.of("Hello", "Wolrd");

        // List<String>이 아님.
        List<String[]> result1 = words.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(Collectors.toList());

        // 이것도 역시 List<String>이 아님
        List<Stream<String>> result2 = words.stream()
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .collect(Collectors.toList());

        // flatMap 사용
        List<String> uniqueCharaters = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(uniqueCharaters);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<Integer> resultNumbers = numbers.stream().map(num -> num * num).collect(Collectors.toList());
        System.out.println("resultNumbers: " + resultNumbers);

        List<Integer> nums1 = List.of(1, 2, 3);
        List<Integer> nums2 = List.of(3, 4);

        List<int[]> numResult = nums1.stream()
                .flatMap(i -> nums2.stream().map(j -> new int[] { i, j }))
                .collect(Collectors.toList());

        numResult.forEach(i -> System.out.println(Arrays.toString(i)));
    }
}
