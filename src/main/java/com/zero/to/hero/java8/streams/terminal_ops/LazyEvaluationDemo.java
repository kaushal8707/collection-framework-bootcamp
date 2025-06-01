package com.zero.to.hero.java8.streams.terminal_ops;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * we can see Filtering not  printed bcz there were no terminal operation
 *  once terminal operation (collect()) invoke
 *  then only stream started executing...
 *
 */
public class LazyEvaluationDemo {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        Stream<String> stream = names.stream()
                .filter(name -> {
                    System.out.println("Filtering..." + name);
                    return name.length() > 3;
                });

        System.out.println("Before Terminal Operation");
        List<String> result = stream.collect(Collectors.toList());
        System.out.println("After Terminal Operation");
        System.out.println(result);

    }
}
