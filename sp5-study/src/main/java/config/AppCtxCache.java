package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;

import aspect.CacheAspect;
import aspect.ExeAspect;
import spring.Calculator;
import spring.ImplRecCalculator;

@Configuration
@EnableAspectJAutoProxy
public class AppCtxCache {
	
	@Bean
	public Calculator calculator() {
		return new ImplRecCalculator();
	}
	
	@Bean
	@Order(1)
	public ExeAspect exeAspect() {
		return new ExeAspect();
	}
	
	@Bean
	@Order(2)
	public CacheAspect cacheAspect() {
		return new CacheAspect();
	}

}
