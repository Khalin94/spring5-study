package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChangePasswordService {
	
	@Autowired
	MemberDao memberDao;
	
	public void changePassword(String email, String oldPwd, String newPwd) {
		
		Member member = memberDao.selectByEmail(email);
		if(member == null) {
			throw new MemberNotFoundException();
		}
		if(oldPwd.equals(newPwd)) {
			throw new SamePasswordException();
		}
		
		member.changePassword(oldPwd, newPwd);

		memberDao.update(member);
	}
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao; 
	}
}
