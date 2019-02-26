package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chap07.Calculator;
import config.AppCtx;
import config.AppCtxWithCache;

public class MainAspect {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtxWithCache.class);
		
		Calculator cal = ctx.getBean("calculator", Calculator.class);
		long fiveFac = cal.factorial(5);
		System.out.println("cal.factorial(5) = " + fiveFac);
		System.out.println(cal.getClass().getName());
		ctx.close();
	}

}
