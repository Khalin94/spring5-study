package chap2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration 이 클래스를 스프링 설정 클래스로 지정
@Configuration
public class AppContext {

	//@Bean(빈 객체) 애노테이션은 한 개의 객체를 생성하고 초기화하는 설정
	//또한 빈 객체는 스프링이 관리하는 빈 객체임.
	//메소드의 이름으로 빈 객체를 구분함.
	@Bean
	public Greeter greeter() {
		Greeter g = new Greeter();
		g.setFormat("%s, 안녕하세요!");
		return g;
	}
	
	@Bean
	public Greeter greeter1() {
		Greeter g = new Greeter();
		g.setFormat("안녕하세요, %s님!");
		return g;
	}

}
