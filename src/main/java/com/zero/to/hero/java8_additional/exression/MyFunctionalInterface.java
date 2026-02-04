package com.zero.to.hero.java8_additional.exression;

@FunctionalInterface
public interface MyFunctionalInterface {

	void m1();
	default void m2() {
		System.out.println("Inside method m2");
	}
	default void m3() {
		System.out.println("Inside method m3");
	}
	static void m4() {
		System.out.println("Inside method m4");
	}
}
