package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import spring.MemberDao;
import spring.MemberPrinter;

//@ComponentScan(basePackages = {"spring"}, excludeFilters = @Filter(type = FilterType.REGEX, pattern = "spring\\..*Dao"))
@ComponentScan(basePackages = {"spring"}, excludeFilters = {@Filter(type = FilterType.ASPECTJ, pattern = "spring.*Dao"),
															@Filter(type = FilterType.ASPECTJ, pattern = "spring.MemberPrinter")
})
@Configuration
public class AppConfigWithExclude {
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}

	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
}
