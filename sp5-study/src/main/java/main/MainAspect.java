package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtxAspect;
import spring.Calculator;

public class MainAspect {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtxAspect.class);
		
		Calculator cal = ctx.getBean("calculator", Calculator.class);
		long fiveFac = cal.factorial(5);
		System.out.println("cal(5) : "+ fiveFac);
		System.out.println(cal.getClass().getName());
		ctx.close();
	}

}
