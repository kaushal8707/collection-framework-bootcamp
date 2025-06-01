package com.zero.to.hero.java8.streams.primitivestreams;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveStreams {
    public static void main(String[] args) {

        /**
         * till now we saw the examples on Wrapper class like Integer, Double, String...not in primitive data type like int, long...
         *
         *
         *
         */
        int[] numbers = {1,2,3,4,5};
        IntStream stream = Arrays.stream(numbers);   //While we use primitive int type to convert in stream
                                                     // it will give IntStream instead of Stream
        Integer[] numbers1 = {1,2,3,4,5};            // While we use Wrapper class Integer type
        Stream<Integer> stream1 = Arrays.stream(numbers1); // it will give Stream

        Stream<Integer> boxed = Arrays.stream(numbers).boxed();  // boxed will convert IntStream to Stream of Integer

        System.out.println(IntStream.range(1, 5).boxed().collect(Collectors.toList()));  // boxed() convert to Stream Wrapper class

        System.out.println(IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList()));

        System.out.println(IntStream.iterate(1, i-> i+1).boxed().limit(6).collect(Collectors.toList()));

        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
        OptionalInt max = intStream.max();
        System.out.println(max.getAsInt());

        DoubleStream doubles = new Random().doubles(5);
        System.out.println(doubles.sum());
        System.out.println(doubles.max());
        System.out.println(doubles.min());
        System.out.println(doubles.average());
        System.out.println(doubles.count());
        System.out.println(doubles.boxed().toList());

        IntStream ints = new Random().ints(5);
        System.out.println(ints.boxed().toList());
    }
}
