package com.zero.to.hero.java8_additional.exression;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Builder
@Getter
@Setter
@ToString
public class Books implements Comparable<Books> {
	
	private int id;
	private String name;
	private Integer pages;
	
	//Traditional Approach for Comparable
	@Override
	public int compareTo(Books b) {
		if(this.name.compareTo(b.getName())>0)
			return 1;
		else if (this.name.compareTo(b.getName())<0)
			return -1;
		else
			return 0;
	}
	
	public static void main(String[] args) {
		List<Books> listOfBooks =  Arrays.asList(new Books(123, "Java", 345),
				new Books(768, "Mava", 3434),
				new Books(567, "Pava", 9887),
				new Books(432, "Lava", 23131));
		Collections.sort(listOfBooks);
		listOfBooks.forEach(System.out::print);	
		
		//Comparable using Lambda Expression
		//Collections.sort(null);
	}
}
