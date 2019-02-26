package spring;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberInfoPrinter {
	/*
	 * 변수에 @Autowired를 붙여 Appconfig파일에서 setter를 불러오지 않아도
	 * 자동으로 의존 주입이 가능하게 된다.
	 */

	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberPrinter printer;

	public void printMemberInfo(String email) {
		Member member = memberDao.selectByEmail(email);
		if(member == null) {
			System.out.println("회원 정보가 없습니다.");
			return;
		}
		
		printer.print(member);
		System.out.println();
	}
	
	//setter를 통해 의존을 주입 받는다.
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}

}
