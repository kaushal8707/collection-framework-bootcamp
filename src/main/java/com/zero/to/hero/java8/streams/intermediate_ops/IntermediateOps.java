package com.zero.to.hero.java8.streams.intermediate_ops;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOps {
    public static void main(String[] args) {

        // Intermediate operations transform a stream into another stream
        // They are lazy which means they won't execute until a terminal operation invoked.

        // 1. filter
        List<String> list = Arrays.asList("Akash", "Ronak", "Saurav", "girmu", "Akash");
        Stream<String> filteredStream = list.stream().filter(x -> x.startsWith("A"));
        // no filtering at this point
        long res = list.stream().filter(x -> x.startsWith("A")).count();
        System.out.println(res);

        // 2. map
        Stream<String> stringStream = list.stream().map(String::toUpperCase);

        // 3. sorted
        Stream<String> sorted = list.stream().sorted();
        Stream<String> sortedStringUsingComparator = list.stream().sorted((a, b) -> a.length() - b.length());

        // 4. distinct
        long countDistinct = list.stream().filter(x -> x.startsWith("A")).distinct().count();
        System.out.println(countDistinct);

        // 5. limit
        long count = Stream.iterate(1, x -> x + 1).limit(100).count();
        System.out.println(count);

        // 5. skip
        long skippedCount = Stream.iterate(1, x -> x + 1).skip(5).limit(100).count();
        System.out.println(skippedCount);

        // 6. limit
        Stream.iterate(1, x-> x+1).skip(5).limit(10).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("------------------------");
        Stream.iterate(1, x-> x+1).limit(10).collect(Collectors.toList()).forEach(System.out::println);

        // 7. peek                                        // foreach() is our terminal operation where we consume something
                                                          // same work peek will also do but peek is an Intermediate operation
                                                          // peek() will perform one action on each element as it is consumed
        Stream.iterate(1, x -> x + 1).skip(10).limit(100).peek(System.out::println).count();

        // 8. flatMap
        // Handle streams of collections, lists or arrays where each elements is itself a collection.
        // Flatten nested structure(eg. lists within lists) so that they can be processed as a single sequence of elements.
        // Transform and Flatten elements at same time
        // map will transform data and flat will convert nested into a single stream

        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("orange", "kiwi"),
                Arrays.asList("pear", "grape")
        );
        /** how to get kiwi */
        System.out.println(listOfLists.get(1).get(1));
        /** I don't want in a nested way , I want in a flat way */
        List<String> list1 = listOfLists.stream()
                .flatMap(x -> x.stream())   // one single list converted into a unified list
                .map(String::toUpperCase)
                .toList();
        System.out.println(list1);

        /** we want multiple strings into a single string */
        List<String> sentences = Arrays.asList(
                "Hello world",
                "Java streams are powerful",
                "flat map is useful");
        List<String> flatteredList = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))   // it will convert one unified array into a stream
                .map(String::toUpperCase)
                .toList();
        System.out.println(flatteredList);




    }
}
