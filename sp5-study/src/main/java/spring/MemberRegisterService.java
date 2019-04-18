package spring;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberRegisterService {
	
	@Autowired
	MemberDao memberDao;
	
	public MemberRegisterService() {
		
	}
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public Long register(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
			if(member != null) {
				throw new DuplicateException();
			}
			Member newMember = new Member(req.getEmail(), req.getName(), req.getPassword(), LocalDateTime.now());
			memberDao.insert(newMember);
			
			return newMember.getId();
			
		}
		
	}


