package com.zero.to.hero.java8_additional.streams;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeUsingJava8 {
    public static void main(String[] args) {
        IntStream stream=IntStream.range(1,100);
        stream.filter(PrimeUsingJava8::isPrime)
                .boxed()
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static boolean isPrime(int number){
        return IntStream.rangeClosed(2, number/2).noneMatch(i->number%i==0);
    }
}
