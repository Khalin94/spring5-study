package main;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.PropertyConfig;
import spring.Info;

public class MainUseValueAnno {
	
	private static AnnotationConfigApplicationContext ctx = null;

	public static void main(String[] args) {
		ctx = new AnnotationConfigApplicationContext(PropertyConfig.class);
		Info info = ctx.getBean(Info.class);
		info.printVersion();
//		Info info = new Info();
//		info.printVersion();
		
	}
}
