package spring;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberRegisterService {
	
	/* 
	 private MemberDao = new MemberDao();
	 위와 같이 직접 의존 객체를 생성하지 않음.

	*/
	@Autowired
	private MemberDao memberDao; //생성자를 통해 memberDao를 주입 받음.
	
	public MemberRegisterService() {
		
	}
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public Long regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null) {
			throw new DuplicateMemberException("dup email" + req.getEmail());
		}
		
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());
		memberDao.insert(newMember);
		return newMember.getId();
	}
}
