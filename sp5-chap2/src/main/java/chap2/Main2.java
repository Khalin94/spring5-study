package chap2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		Greeter g1 = ctx.getBean("greeter", Greeter.class);
		Greeter g2 = ctx.getBean("greeter1", Greeter.class);
		Greeter g3 = ctx.getBean("greeter", Greeter.class); //g1과 같은 빈 객체를 생성함.
		/*
		 Greeter g1 = ctx.getBean("greeter", Greeter.class);
		 Greeter g2 = ctx.getBean("greeter", greeter.class);
		 
		 별도 설정이 없을 경우 스프링은 한 개의 빈 객체를 생성하고 한 개의 빈 객체는
		 싱글톤의 범위를 갖는다.
		 즉, @Bean 애노테이션 하나당 한 개의 빈 객체를 생성한다.
		 */
		System.out.println("g1 == g3 : " + (g1 == g3));
		System.out.println("g1 == g2 : " + (g1 == g2));
		String msg = g1.greet("스프링");
		String msg1 = g2.greet("스프링");
		System.out.println(msg);
		System.out.println(msg1);
		ctx.close();
	}

}
