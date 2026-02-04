package com.zero.to.hero.java8_additional.exression;

public class MyFunctionalImpl {

	public static void main(String[] args) {

		MyFunctionalInterface mfi = 
							()-> System.out.println("Inside method m1");
		mfi.m1();
		mfi.m2();
		MyFunctionalInterface.m4();
	}

}
