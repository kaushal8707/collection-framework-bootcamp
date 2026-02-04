package com.zero.to.hero.java8_additional.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NewJoinee {
	private String name;
	private String address;
	private double fee;
}
