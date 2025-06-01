package com.zero.to.hero.java8.streams.terminal_ops;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOps {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3);

        // 1. collect
        list.stream().skip(1).collect(Collectors.toList());        //it takes an element and create a new list and return that list
        list.stream().skip(1).toList();                            // same as collect(Collectors.toList()) as per new java version

        // 2. foreach
        list.stream().forEach(x-> System.out.println(x));

        // 3. reduce: Combine elements to produce a single result   //reduce take a BinaryOperator means BiFunction with 2 same type input with same return type
        Optional<Integer> optionalInteger = list.stream().reduce((a, b) -> (a + b));  //take BiFunction, we accumulate result in a single value like sum of all elements
        System.out.println(optionalInteger.get());
        /** find sum of only even numbers */
        Optional<Integer> optionalInteger1 = list.stream().filter(x -> x % 2 == 0).reduce((x, y) -> x + y);
        System.out.println(optionalInteger1.get());
        /** max */
        Optional<Integer> optionalInteger2 = list.stream().reduce(Integer::max);
        System.out.println(optionalInteger2.get());
        /** min */
        Optional<Integer> optionalInteger3 = list.stream().reduce(Integer::min);
        System.out.println(optionalInteger3.get());

        // 4. count

        // 5. anyMatch, allMatch, noneMatch
        /** anyMatch(), allMatch() , noneMatch()- all are short-circuit methods */
        /** short-circuit op- as soon as they find something/find match then they stop processing rest of the elements */

        boolean b = list.stream().anyMatch(x -> x % 2 == 0);   // anyMatch return true when any single elements from a list
        System.out.println(b);                                 // satisfied predicate
        boolean b1 = list.stream().allMatch(x -> x > 0);       /**allMatch() -  once found any element not match return false no need to check all elements */
        System.out.println(b1);                                // allMatch return true when all elements in a list satisfied predicate
        boolean b2 = list.stream().noneMatch(x -> x < 0);      // noneMatch return true when none of elements in a list
        System.out.println(b2);                                // satisfied predicate

        // 6. findFirst, findAny
        /** findFirst(), findAny() - all are short-circuit methods */
        /** short-circuit op- as soon as they find something/find match then they stop processing rest of the elements */

        System.out.println(list.stream().findFirst().get());
        System.out.println(list.stream().findAny().get());

        // 7. toArray
        Object[] array = Stream.of(1, 2, 3).toArray();

        // 8. min/max
        /** important    min always starting element..........max always top last element not like value min/max*/
        System.out.println("Max if ascending order element there - "+Stream.of(2, 64,44).max(Comparator.naturalOrder()).get());
        System.out.println("Max if descending order element there - "+Stream.of(2, 64,44).max(Comparator.reverseOrder()).get());
        System.out.println("Max if descending order element there - "+Stream.of(2, 64,44).max((m, n)-> n-m).get());             //64 44-> a-b=+ve
        System.out.println("Min - "+Stream.of(2, 64,44).min(Comparator.naturalOrder()).get());

        // forEachOrdered
        /** when stream is parallel then forEach() run randomly or in an arbitrarily*/
        /** but if you want to print in a order in parallel stream you can use forEachOrdered */
        List<Integer> numbers0 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("using foreach with parallel stream");
        numbers0.parallelStream().forEach(System.out::println);
        System.out.println("using foreachOrdered with parallel stream");
        numbers0.parallelStream().forEachOrdered(System.out::println);

        // Examples: Filtering & Collecting Names
        /** find names whose length is greater than length 3*/
        List<String> names = Arrays.asList("Anna", "Bob", "Charlie", "David");
        System.out.println(names.stream().filter(x-> x.length()>3).toList());

        // Examples: Squaring & Sorting Numbers
        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 6);
        System.out.println(numbers.stream().map(x-> x*x).sorted().toList());

        // Examples: Summing Values
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(list1.stream().reduce(Integer::sum).get());

        // Examples: Counting occurrence of character
        String sentence = "Hello World";
        // char[] charArray = sentence.toCharArray();                      // Arrays.stream(_ _ _ _) won't take character array
        System.out.println(sentence.chars().filter(x-> x=='l').count());   // so, they provide string.chars()...which give IntStream

        // Stateful & Stateless operations
        /**
         * Stateless operation - If any operations which is having Idea about rest of the elements
         *                    for example - map() he doesn't care about rest of elements he takes just one element and perform action at one time he looks only one element
         *
         * Stateful operation - for example - sorted(), distinct() to perform stateful operations all elements should be knowing.
         *
         */

        // Example
        /** Streams cannot be reused after a terminal operation has been called */
        Stream<String> stream = names.stream();
        stream.forEach(System.out::println);
       // List<String> list3 = stream.map(String::toUpperCase).toList();   //exception

    }
}
