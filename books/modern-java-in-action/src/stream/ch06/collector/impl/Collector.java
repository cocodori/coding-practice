package stream.ch06.collector.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

// T: 스트림 요소의 형식
// A: 중간 결과를 누적하는 객체의 형식
// R: collect 연산의 최종 결과 형식
public interface Collector<T, A, R> {

    Supplier<A> supplier();
    BiConsumer<A, T> accumulator();
    BinaryOperator<A> combiner();
    Function<A, R> finisher();
    Set<java.util.stream.Collector.Characteristics> characteristics();



}
