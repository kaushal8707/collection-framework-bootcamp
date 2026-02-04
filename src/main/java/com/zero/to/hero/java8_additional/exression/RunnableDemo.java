package com.zero.to.hero.java8_additional.exression;

public class RunnableDemo {

	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("run method"+"--"+Thread.currentThread().getName());
			}
		};
		new Thread(runnable).start();
		
		Runnable runnable1 = 
				()->System.out.println("run method"+"--"+Thread.currentThread().getName());		
		runnable1.run();
	}

}
