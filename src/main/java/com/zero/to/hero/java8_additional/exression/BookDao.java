package com.zero.to.hero.java8_additional.exression;

import java.util.Arrays;
import java.util.List;

public class BookDao {

	public static List<Book> getBooks(){
		return Arrays.asList(new Book(123, "Java", 345),
				new Book(768, "Mava", 3434),
				new Book(567, "Pava", 9887),
				new Book(432, "Lava", 23131));
	}
}
