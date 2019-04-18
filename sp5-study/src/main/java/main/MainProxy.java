package main;

import spring.ExeTimeCalculator;
import spring.ImplCalclulator;
import spring.ImplRecCalculator;

public class MainProxy {
	
	public static void main(String[] args) {
		ExeTimeCalculator calculator= new ExeTimeCalculator(new ImplCalclulator());
		System.out.println(calculator.factorial(20));
	
		ExeTimeCalculator recCalculator = new ExeTimeCalculator(new ImplRecCalculator());
		System.out.println(recCalculator.factorial(20));
			
		
	}

}
