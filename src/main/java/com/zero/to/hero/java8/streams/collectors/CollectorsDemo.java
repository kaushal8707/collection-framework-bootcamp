package com.zero.to.hero.java8.streams.collectors;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * How Arrays and Collections are a Utility classes same like Collectors also a Utility class
 *
 *
 */
public class CollectorsDemo {
    public static void main(String[] args) {

        // Collectors is a Utility class
        // provides a set of methods to create common collectors

        /** 1. Collecting to a List */
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> res = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println(res);

        /** 2. Collecting to a Set */
        List<Integer> nums = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        Set<Integer> set = nums.stream().collect(Collectors.toSet());
        System.out.println(set);

        /** 3. Collecting to a specific Collection
         * Collectors.toCollection() will give you any collection and use supplier to provide empty collection
         * */
        ArrayDeque<String> collect = names.stream().collect(Collectors.toCollection(() -> new ArrayDeque<>()));

        /** 4. Joining Strings
         * concatenate stream elements into a single stream
         * */
        String concatenatedNames = names.stream().map(String::toUpperCase).collect(Collectors.joining(","));
        System.out.println(concatenatedNames);

        /** 5. Summarizing data
         *  generates statistical data (count, sum, min, average, max)
         *
         * */
        List<Integer> numbers = Arrays.asList(2, 3, 5, 7, 11);
        IntSummaryStatistics stats = numbers.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println("Count : "+stats.getCount());
        System.out.println("Min : "+stats.getMin());
        System.out.println("Max : "+stats.getMax());
        System.out.println("Sum : "+stats.getSum());
        System.out.println("Average : "+stats.getAverage());

        /** 6. Calculating Averages
         */
        Double average = numbers.stream().collect(Collectors.averagingInt(x -> x));
        System.out.println("Average - "+average);

        /** 7. Counting elements
         */
        Long count = numbers.stream().collect(Collectors.counting());
        System.out.println("count - "+count);

        /** 8. Grouping elements
         * based on string's length need to do grouping
         */

        /** -> signature 1 -> groupingBy(Function<? super T, ? extends K> classifier) */
        List<String> words = Arrays.asList("Hello", "World", "Java", "Streams", "Collecting");
        Map<Integer, List<String>> groupedOnLength = words.stream()                                    /** based on length of string it will group/divide the given elements*/
                                                      .collect(Collectors.groupingBy(String::length));  /** signature- groupingBy(Function<? super T, ? extends K> classifier)*/
        System.out.println(groupedOnLength);                                                            /** op- {4=[Java], 5=[Hello, World], 7=[Streams], 10=[Collecting]} */


        /** -> signature 2 -> groupingBy(Function<? super T, ? extends K> classifier, Collector<? super T, A, D> downstream) */
        Map<Integer, String> groupedElementJoined = words.stream()                                  /** with classified we are using 1 downstream collector*/
                .collect(Collectors.groupingBy(String::length, Collectors.joining(",")));  /** after grouping elements do you want to perform any operations on grouped elements*/
        System.out.println(groupedElementJoined);                                                  /** signature- groupingBy(Function<? super T, ? extends K> classifier, Collector<? super T, A, D> downstream)*/
                                                                                                    /** op-{4=Java, 5=Hello,World, 7=Streams, 10=Collecting} */
        Map<Integer, Long> groupedElementCount = words.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));            /** op-{4=1, 5=2, 7=1, 10=1} */
        System.out.println(groupedElementCount);


        /** -> signature 3 -> groupingBy(Function<? super T, ? extends K> classifier, Supplier<M> mapFactory, Collector<? super T, A, D> downstream
         * classifier - on which basis/criteria want to create a group
         * Collector downstream - if you want performed any operations on grouped elements
         * Supplier - It is like a map factory. which will give you a specific map implementation like LinkedHashMap, TreeMap ...etc
         */
        TreeMap<Integer, Long> treeMap = words.stream()
                .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));  // Tree Map sort Map based on key
        System.out.println(treeMap);                                                     /** op- {4=1, 5=2, 7=1, 10=1}*/

        Map<Integer, Long> linkedHashMap = words.stream()
                .collect(Collectors.groupingBy(String::length, LinkedHashMap::new, Collectors.counting()));  // LinkedHashMap maintain Map based on key insertion order */
        System.out.println(linkedHashMap);                                              /** op- {5=2, 4=1, 7=1, 10=1}*/


        /** 9. Partitioning elements
         * partitions elements into two groups(true or false) based on predicate
         * scenario - will create 2 group whose length less than 5 in one group and whose length greater than 5 in another group
         * */

        /** -> signature 1 -> partitioningBy(Predicate<? super T> predicate) */
        Map<Boolean, List<String>> partitionedOnLength = words.stream()       /** {op - false=[Hello, World, Java], true=[Streams, Collecting]}*/
                .collect(Collectors.partitioningBy(x -> x.length() > 5));
        System.out.println(partitionedOnLength);

        /** -> signature 2 -> partitioningBy(Predicate<? super T> predicate, Collector<? super T, A, D> downstream)*/
        Map<Boolean, String> partitionedElementJoining = words.stream()       /** op- {false=Hello-World-Java, true=Streams-Collecting}*/
                .collect(Collectors.partitioningBy(x -> x.length() > 5, Collectors.joining("-")));
        System.out.println(partitionedElementJoining);


        /** 10. Mapping & Collecting
         *
         *  Applies a mapping function before collecting
         *  you can say this is a shortcut of not writing a separate map
         *  signature - mapping(Function<? super T, ? extends U> mapper, Collector<? super U, A, R> downstream)
         */
        System.out.println(words.stream().collect(Collectors.mapping(x-> x.toUpperCase(), Collectors.toList())));
        System.out.println(words.stream().collect(Collectors.mapping(x-> x.length(), Collectors.toSet())));
        System.out.println(words.stream().collect(Collectors.mapping(x-> x, Collectors.toMap(x->x, y->y.length()))));


        System.out.println("------------Examples - Practice Example-----------------");


    }
}
