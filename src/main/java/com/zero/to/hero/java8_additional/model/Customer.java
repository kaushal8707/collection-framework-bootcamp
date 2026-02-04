package com.zero.to.hero.java8_additional.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
public class Customer {

	private int id;
	private long salary;
	private String name;
	private String email;
	private List<String> phoneNumbers;
}
