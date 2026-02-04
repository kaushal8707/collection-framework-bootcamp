package com.zero.to.hero.java8_additional.stream;

import java.util.stream.IntStream;

public class StreamVSParallelStreamExample {

	public static void main(String[] args) {
		
	  IntStream.range(1, 10).forEach(x->{
   		  
   		  System.out.println("Stream -> Thread - "+Thread.currentThread().getName()+"   "+x);
   	  });
	  
   	  IntStream.range(1, 10).parallel().forEach(x->{
   		  
   		  System.out.println("Parallel Stream -> Thread - "+Thread.currentThread().getName()+"   "+x);
   	  });
	}

}
