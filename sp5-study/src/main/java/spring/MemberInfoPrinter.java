package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("infoPrinter")
public class MemberInfoPrinter {
	
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	public void printInfo(String email) {
		Member member = memberDao.selectByEmail(email);
		if(member == null) {
			System.out.println("No data");
			return;
		}
		printer.print(member);
		System.out.println();
	}

	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@Autowired
	@Qualifier("printer")
	//memberSummaryPrinter를 이용하기 위한 방법
	//1. 지금처럼 qualifier 사용
	//2. setPrinter의 파라미터를 MemberSummaryPrinter로 바꿔줌
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	

}
