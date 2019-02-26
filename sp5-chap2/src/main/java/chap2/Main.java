package chap2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		//AnnotationConfigApplicationContext 클래스는 자바 설정 정보를 읽어와
		//빈 객체를 생성하고 관리한다.
		//파라미터로 AppContext를 지정함.
		// 즉 AnnotationConfigApplicationContext는 객체 생성 및 초기화
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		//getBean메서드는 AnnotationConfigApplicationContext의 설정을 읽어와
		//생성한 빈 객체를 검색한다.
		//첫번째 파라미터는 빈 객체의 이름(AppContext의 @Bean 메서드),
		//두번째 파라미터는 빈 객체의 타입
		Greeter g = ctx.getBean("greeter", Greeter.class);// getBean은 생성된 빈 객체 검색
		String msg = g.greet("스프링");
		System.out.println(msg);
		ctx.close();
	}

}
