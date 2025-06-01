

Parallel Stream

         A type of stream that enables parallel processing of elements
         Allowing multiple threads to process parts of the streams simultaneously
         This can significantly improve performance for large data sets
         workload is distributed across multiple threads


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

    }

    private static long factorial(int n){
        long result = 1;
        for(int i=2;i<=n;i++){
            result*=i;
        }
        return result;
    }
}