package com.zero.to.hero.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Java8Demo {
    public static void main(String[] args) {

        //Streams

        // Java 8 -> minimal Code, Functional Programming

        // Java 8 -> lambda expression, Streams, Date & Time API

        // lambda expression
        // lambda expression is an anonymous function (no name, no return type, no access modifier)

        // lambda expression used to implement functional interface

        // functional interface -> an interface which is having only one interface.

        // @Functional Interface we use to denote in future not to add any other abstract method as we define only one
        // so, It's a good practise to use @FunctionalInterface bcz if anyone try to add it will give compile time error

        /** functional interface reference can hold lambda expression that is called functional programming
         *  here we have a function (a, b)-> a+b; and we are treating as a variable.
         *
        */

        Thread t1 = new Thread(()-> {                  // line 23-29 covered or replaced using lambda expression
            System.out.println("Hello !");
        });
        t1.start();

        System.out.println("--------------------------------");

        MathOperation summation = (a, b)-> a+b;         // line 41-53 covered or replaced using lambda expression
        MathOperation subtraction = (a, b)-> a-b;

        int operate = summation.operate(4, 5);
        System.out.println(operate);


        //Predicate --> Functional Interface  - method -> boolean test(T t)

        /**
         * predicate (boolean-valued function) of one argument.
         *  boolean test(T t)   -  abstract method
         *  or, and   -  default method
         * It always returns boolean value
         * having one abstract method - boolean test(T t)     -> It can take any parameter   always return either true or false
         * If you want to check anything then use predicate
         * Predicate only hold one and only one conditions
         * => We are just storing a conditions into a Variable that is called a functional programming
         *
         * */

        Predicate<Integer> isEven = x-> x % 2 == 0;
        System.out.println(isEven.test(4));

        Predicate<String> isWordStartingWith = x -> x.toLowerCase().startsWith("a");
        Predicate<String> isWordEndingWith = x -> x.toLowerCase().endsWith("t");
        Predicate<String> and = isWordStartingWith.and(isWordEndingWith);
        System.out.println(and.test("Ankit"));


        //Function --> Functional Interface   - method -> R apply(T t);

        /**
         *  Function -> will work for you like Predicate takes a conditions but Function will take input perform operation and give one output/result
         *  apply() - abstract method
         *  andThen(), compose(), identity() - default methods
         *
         */

        Function<Integer, Integer> doubleIt = x -> 2 * x;
        Function<Integer, Integer> tripleIt = x -> 3 * x;

        System.out.println(doubleIt.andThen(tripleIt).apply(10));
        System.out.println(tripleIt.andThen(doubleIt).apply(10)); // same
        System.out.println(doubleIt.compose(tripleIt).apply(10)); // same  -> compose perform in reverse order of andThen
        System.out.println(doubleIt.apply(100));


        Function<Integer, Integer> identity = Function.identity();     // what you will give in input same you will get in output
        Integer resp = identity.apply(5);
        System.out.println(resp);


        //Consumer --> Functional Interface   - method -> void accept(T t);

        /**
         *  Consumer -> It will take an Input but won't return any value
         *  void accept(T t)        - abstract method
         */

        Consumer<Integer> print = x -> System.out.println(x);
        print.accept(51);
        List<Integer> list = Arrays.asList(1,2,3);
        Consumer<List<Integer>> printList = x -> {
            for(int i : x){
                System.out.println(i);
            }
        };
        printList.accept(list);

        //Supplier --> Functional Interface   - method -> void accept(T t);

        /**
         *  Supplier -> Supplier won't take anything but give some result
         *   T get();
         */

        Supplier<String> giveHelloWorld = () -> "Hello World !!";
        System.out.println(giveHelloWorld.get());


        //combined example

        Predicate<Integer> predicate = x -> x % 2 == 0;
        Function<Integer, Integer> function = x -> x * x;
        Consumer<Integer> consumer = x -> System.out.println(x);
        Supplier<Integer> supplier = () -> 100;

        if(predicate.test(supplier.get())) {
            consumer.accept(function.apply(supplier.get()));
        }

    }
}

/** Example - 1  lambda expression */
class Task implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello !!");
    }
}

/** Example - 2  lambda expression */

interface MathOperation {
    int operate(int a, int b);
}

// earlier we implement like this below

class SumOperation implements MathOperation{

    @Override
    public int operate(int a, int b) {
        return (a+b);
    }
}