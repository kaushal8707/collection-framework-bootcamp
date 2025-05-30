
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


Predicate --> Functional Interface  - method -> boolean test(T t)

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


Function --> Functional Interface   - method -> R apply(T t);

        /**
         *  Function -> will work for you like Predicate takes a conditions but Function will take input perform operation and give one output/result
         *  apply() - abstract method
         *  andThen(), compose(), identity() - default methods
         *
         */


Consumer --> Functional Interface   - method -> void accept(T t);

        /**
         *  Consumer -> It will take an Input but won't return any value
         *  void accept(T t)        - abstract method
         */


Supplier --> Functional Interface   - method -> void accept(T t);

        /**
         *  Supplier -> Supplier won't take anything but give some result
         *   T get();
         */


combined example

        Predicate<Integer> predicate = x -> x % 2 == 0;
        Function<Integer, Integer> function = x -> x * x;
        Consumer<Integer> consumer = x -> System.out.println(x);
        Supplier<Integer> supplier = () -> 100;

        if(predicate.test(supplier.get())) {
            consumer.accept(function.apply(supplier.get()));
        }


** Important Concept 
 UnaryOperator, BinaryOperator

        Function<Integer, Integer> doubledIt = x -> 2 * x;         // here we are taking an Integer and returning an Integer
                                                                   // so here we are doing duplicate for input and output type same
                                                                   // for this Java has Introduce UnaryOperator.
        UnaryOperator<Integer> doubledIt1 = x -> 2 * x;            // UnaryOperator<T> extends Function<T, T>
        BinaryOperator<Integer> b = (x, y) -> (x + y);             // BinaryOperator<T> extends BiFunction<T,T,T>
                                                                   // In BinaryOperator<T> all type will be same 2 input and 1 output type

        
 Method Reference : use method without invoking & in place of lambda expression

        List<String> students = Arrays.asList("abc","def","ghi");
        students.forEach(x -> System.out.println(x));                              // replace with Method Reference
        students.forEach(System.out::println);

  Constructor Reference
        
        List<String> names = Arrays.asList("A","B","C");
        List<MobilePhone> mobilePhoneList = names.stream()
                .map(x -> new MobilePhone(x)).collect(Collectors.toList());        // replace with Constructor Reference
        mobilePhoneList.forEach(System.out::println);

        List<MobilePhone> mobilePhoneList2 = names.stream()
                .map(MobilePhone::new).collect(Collectors.toList());
        mobilePhoneList2.forEach(System.out::println);
