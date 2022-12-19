package stream.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));

        // 2011년에 일어난 모든 트랜잭션을 찾아서 값을 오름차순 정렬
        List<Transaction> tr2011 = transactions.stream()
                .filter(tr -> tr.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        System.out.println("tr2011: " + tr2011);

        // 거래자가 근무하는 모든 도시를 중복없이 나열.
        Set<String> cities = transactions.stream()
                .map(tr -> tr.getTrader().getCity())
                .collect(Collectors.toSet());

        System.out.println("cities: " + cities);

        // 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순 정렬
        Set<Trader> traders = transactions.stream()
                .filter(tr -> tr.getTrader().getCity().equals("Cambridge"))
                .map(tr -> tr.getTrader())
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toSet());

        System.out.println("Traders: " + traders);

        // 모든 거래자 이름을 알파벳 순으로 정렬해서 반환
        var names = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);

        System.out.println("names: " + names);

        // 밀라노에 거래자가 있는가?
        boolean milanBased = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));

        System.out.println("milanBased: " + milanBased);

        // 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력
        transactions.stream()
                .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(tr -> System.out.println(tr));

        // 전체 트랜잭션 중 최댓값은?
        Optional<Integer> highestValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);

        System.out.println("max: " + highestValue);

        //전체 트랜잭션 중 최솟값
        Optional<Integer> smallestTransaction = transactions.stream()
            .map(Transaction::getValue)
            .reduce(Integer::min);

        System.out.println("min: " + smallestTransaction);
    }

}