        // feature introduced in java8
        // process collections of data in a functional & declarative manner.
        // simplify data processing.
        // Embrace functional programming.
        // improve readability and maintainability.
        // enable easy parallelism, without multithreading.
        // we convert collections to stream to achieve functional programming & declarative manner

        // What is Stream ?
        // a sequence of elements supporting functional & declarative programminh.

        // How to use Streams ?
        // Source, Intermediate Operation & Terminal Operation.


 Creating Streams.
        
  /** different ways to create a Stream */

  1. from Collection

         List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
         Stream<Integer> stream = list.stream();
        
  2. from Arrays

         String[] array = {"A", "B", "C"};
         Stream<String> stream1 = Arrays.stream(array);
        
  3. using Stream.of()

         Stream<String> stream2 = Stream.of("a", "b");
        
  4. Infinite streams (generate() & iterate())

         Stream<Integer> generate = Stream.generate(() -> 1);  // will generate infinite time 1 , generate use supplier to produce
         //generate.forEach(System.out::println);
         Stream<Integer> generate1 = Stream.generate(() -> 1).limit(10);  // will generate 10 times 1
         generate1.forEach(System.out::println);

         /** iterate() 1st method : <T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
         * UnaryOperator - UnaryOperator same like a Function in java8 where both in & out will be same type
         */

         List<Integer> collect = Stream.iterate(1, x -> x + 1).limit(10).collect(Collectors.toList());
         System.out.println(collect);

         /** iterate() 2nd method : <T> Stream<T> iterate(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next)
         * UnaryOperator - UnaryOperator same like a Function in java8 where both in & out will be same type
         */
 
         List<Integer> evenNumbers = Stream.iterate(1, x -> x + 1).filter(x-> x%2==0).limit(20).collect(Collectors.toList());
         System.out.println(evenNumbers);
         List<Integer> primeNumbers = Stream.iterate(2, x -> x + 1).peek(x-> System.out.println("1-> "+ x))   // iterate() like a for loop
                                      .filter(StreamsDemo::isPrime)
                                      .peek(x-> System.out.println("2 -> "+ x))
                                      .limit(10).collect(Collectors.toList());
         System.out.println(primeNumbers);
        }

         private static boolean isPrime(int number){
           return IntStream.rangeClosed(2, number/2).noneMatch(i-> number%i == 0);
         }