package spring;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("listPrinter")
public class MemberListPrinter {
	
	//@Qualifier("printer")
	private MemberPrinter printer;
	private MemberDao memberDao;

	public MemberListPrinter() {
		
	}

	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
	}
	
	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
			/*for(int i=0; i<members.size(); i++) {
				ArrayList<Member> member = (ArrayList) members;
				printer.print(member.get(i));
		} */
		members.forEach(m -> printer.print(m));
	}
	
	@Autowired
	@Qualifier("memberPrinter")
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}

	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
}
