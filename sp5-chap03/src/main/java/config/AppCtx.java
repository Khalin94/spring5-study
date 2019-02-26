package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;
import spring.VersionPrinter;

@Configuration //스프링 설정 클래스
public class AppCtx {

	/*
	 * Bean 객체 설정 
	 * memberDao() 메서드는 memberDao라는 이름으로 스프링에 등록됨.
	 */
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao()); //memberDao()가 생성한 객체를 
	}												//MemberRegisterService생성자를 통해 주입.
	
	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao()); //setter를 통해 의존 객체를 주입
		return pwdSvc;
	}
	/*
	 * memberRegSvc와 changePwdSvc는 모두 새로 생성된 memberDao()를 받아서 리턴 한다.
	 * 그러므로 매번 새로운 memberDao()객체를 생성한다고 생각할 수 있지만,
	 * spring은 @Bean이 붙은 메서드는 싱글톤 객체임으로 항상 같은 객체를 리턴한다.
	 */
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(memberDao(), memberPrinter());
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemberDao(memberDao());
		infoPrinter.setPrinter(memberPrinter());
		return infoPrinter;
	}
	
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
	
	
}
