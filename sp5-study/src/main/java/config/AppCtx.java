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

@Configuration
@ComponentScan(basePackages = {"spring"})
public class AppCtx {
	
	/*@Bean
	public MemberRegisterService memberRegSvc() {
		//return new MemberRegisterService(memberDao());
		return new MemberRegisterService();
	}*/
	
	/*@Bean
	public ChangePasswordService changePwdSvc() {
		//ChangePasswordService changePwdSvc = new ChangePasswordService();
		//ChangePasswordService 클래스 내에서 Autowired를 해주었기 때문에 
		//setter를 사용하지 않아도 자동으로 의존이 주입된다.
//		changePwdSvc.setMemberDao(memberDao());
		//return changePwdSvc;
		return new ChangePasswordService();
	}*/

	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	//MemberSummaryPrinter는 memberPrinter를 상속하고 있기 
	//때문에(MemberPrinter를 할당할 수도 있기 때문에) error가 남 
	@Bean
	@Qualifier("printer")
	public MemberSummaryPrinter mPrinter() {
		return new MemberSummaryPrinter();
	}

	/*@Bean
	public MemberListPrinter listPrinter() {
		//return new MemberListPrinter(memberDao(), memberPrinter());
		//return new MemberListPrinter();
		//MemberListPrinter listPrinter = new MemberListPrinter();
		return new MemberListPrinter();
	}*/
	
	/*@Bean
	public MemberInfoPrinter infoPrinter() {
		//MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		// MemberInfoPrinter class 내 autowiredㄴ
		infoPrinter.setMemberDao(memberDao());
		infoPrinter.setPrinter(memberPrinter());
		//return infoPrinter;
		return new MemberInfoPrinter();
	}*/
}
