package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtxCache;
import spring.Calculator;

public class MainCache {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtxCache.class);
		
		Calculator cal = ctx.getBean(Calculator.class);
		cal.factorial(5);
		cal.factorial(5);
		cal.factorial(7);
		cal.factorial(7);
		cal.factorial(5);
		cal.factorial(7);
	}

}
