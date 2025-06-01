package com.zero.to.hero.java8.streams.parallelstreams;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ParallelStream {
    public static void main(String[] args) {

//         A type of stream that enables parallel processing of elements
//         Allowing multiple threads to process parts of the streams simultaneously
//         This can significantly improve performance for large data sets
//         workload is distributed across multiple threads

        long startTime = System.currentTimeMillis();
        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(20000).toList();
        List<Long> factorialList = list.stream().map(ParallelStream::factorial).toList();   //stream
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken with sequential stream - "+(endTime-startTime)+" ms ");

        startTime = System.currentTimeMillis();
        factorialList = list.parallelStream().map(ParallelStream::factorial).toList();      //parallel stream
        endTime = System.currentTimeMillis();
        System.out.println("Time taken with parallel stream - "+(endTime-startTime)+" ms ");


        // Parallel streams are more effective for CPU-intensive operation or large datasets where tasks are independent
        // They may add overhead for simple tasks or small datasets

        // Cumulative Sum
        // [1, 2, 3, 4, 5] -> [1, 3, 6, 10, 15]
        /** here answer tasks are depends on other element as well so
         * while using parallelStream let's see how answer will be wrong*/
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        //int sum=0;
        //List<Integer> cumulativeSum = numbers.parallelStream().map(x-> {
           //int i = x + sum; // Variable used in lambda expression should be final or effectively final
           //sum=i;           // so in lambda express only u can use local variable while it is final or effectively final
           //return i;        // but here we can't make final then how we change
                              // we need to make final bcz here parallel processing is happening so inconsistency may occurred  in multithreading
                               /** we can use addAndGet() method */
        //}).toList();
        /** to achieve thread safety we can use Atomic Integer */
        AtomicInteger sum = new AtomicInteger(0);
        List<Integer> cumulativeSum = numbers.parallelStream().map(x-> sum.addAndGet(x)).toList();
        System.out.println("Expected Cumulative sum : [1, 3, 6, 10, 15]");
        System.out.println("Actual Result with parallel stream : "+cumulativeSum);  //answer [15, 14, 12, 9, 5]

        //Note - Result came randomly bcz It's not Independent
        // so, parallely we can do work for independent task
        // so you need to use wisely parallel stream
        // bcz cumulative sum relies on a sequential order sum but parallel stream won't guarantee for order of execution
        //  If you use stream here it will work expected

        System.out.println("---------------------------");
        AtomicInteger sum1 = new AtomicInteger(0);
        List<Integer> cumulativeSum1 = numbers.stream().map(x-> sum1.addAndGet(x)).toList();
        System.out.println("Expected Cumulative sum : [1, 3, 6, 10, 15]");
        System.out.println("Actual Result with parallel stream : "+cumulativeSum1);  //answer [1, 3, 6, 10, 15]


    }

    private static long factorial(int n){
        long result = 1;
        for(int i=2;i<=n;i++) {
            result*=i;
        }
        return result;
    }
}
