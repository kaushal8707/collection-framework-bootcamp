package com.zero.to.hero.java8_additional.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Builder
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class Student {
	private int id;
	private String name;
	private String address;
	private double fee;
}
