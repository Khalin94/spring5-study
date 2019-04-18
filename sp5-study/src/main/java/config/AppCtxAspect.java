package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import aspect.ExeAspect;
import spring.Calculator;
import spring.ImplRecCalculator;

@Configuration
@EnableAspectJAutoProxy
public class AppCtxAspect {
	
	@Bean
	public ExeAspect exeAspect() {
		return new ExeAspect();
	}
	
	@Bean
	public Calculator calculator() {
		return new ImplRecCalculator();
	}

}
