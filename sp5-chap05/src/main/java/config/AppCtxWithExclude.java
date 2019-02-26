package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import spring.MemberDao;
import spring.MemberPrinter;

@Configuration
@ComponentScan(basePackages= {"spring","spring2"}, 
excludeFilters = { @Filter(type = FilterType.ANNOTATION, classes = ManualBean.class),
				@Filter(type = FilterType.ASPECTJ, pattern = "spring.*Dao")
})
public class AppCtxWithExclude {
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}

}
