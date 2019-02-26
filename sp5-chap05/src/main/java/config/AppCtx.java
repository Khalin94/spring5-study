package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;
import spring.MemberSummaryPrinter;
import spring.VersionPrinter;

@Configuration //스프링 설정 클래스
@ComponentScan(basePackages= {"spring", "spring2"})
public class AppCtx {
/*
	
	 * Bean 객체 설정 
	 * memberDao() 메서드는 memberDao라는 이름으로 스프링에 등록됨.
	 
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		//return new MemberRegisterService(memberDao()); //memberDao()가 생성한 객체를 
		return new MemberRegisterService();
	}												//MemberRegisterService생성자를 통해 주입.
	
	@Bean
	public ChangePasswordService changePwdSvc() {
		//ChangePasswordService pwdSvc = new ChangePasswordService();
		//pwdSvc.setMemberDao(memberDao()); //setter를 통해 의존 객체를 주입
		//의존 주입을 하지 않아도 스프링은 Autowired가 붙은 변수에 해당 타입의 빈객체를 찾아서 주입.
		//return pwdSvc;
		return new ChangePasswordService();
	}
	*//*
	 * memberRegSvc와 changePwdSvc는 모두 새로 생성된 memberDao()를 받아서 리턴 한다.
	 * 그러므로 매번 새로운 memberDao()객체를 생성한다고 생각할 수 있지만,
	 * spring은 @Bean이 붙은 메서드는 싱글톤 객체임으로 항상 같은 객체를 리턴한다.
	 */
	/*
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	*/
	
	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}
	
	@Bean
	@Qualifier("summaryPrinter")
	public MemberSummaryPrinter memberPrinter2() {
		return new MemberSummaryPrinter();
	}
	
/*	@Bean
	public MemberListPrinter listPrinter() {
		//return new MemberListPrinter(memberDao(), memberPrinter());
		return new MemberListPrinter();
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		//MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		//infoPrinter.setMemberDao(memberDao());   //MemberInfoPrinter에서 setter메소드에 @Autowired를 사용함.
		//infoPrinter.setPrinter(memberPrinter());
		//return infoPrinter;
		//return new MemberInfoPrinter();
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setPrinter(memberPrinter2());
		return infoPrinter;
	}
	*/
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
	
	
}
