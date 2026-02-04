package com.zero.to.hero.java8_additional.exression;

public class CalculatorImpl //implements Calculator
{

	
	
	//Traditional Approach
//	@Override
//	public void switchOn() {
//		System.out.println("Calculator switched on"); 
//	}
//	
	public static void main(String[] args) {
		//new CalculatorImpl().switchOn();
		
		//using lambda expression
		
//		Calculator calc = ()->System.out.println("Invoke switched on using lambda");
//		calc.switchOn();
		
		Calculator calcParam = (d)->{
			if(d>10)
				System.out.println("greater than");
			else
				System.out.println("less than");
		};
		calcParam.printNum(1);
		
	}
	
}
