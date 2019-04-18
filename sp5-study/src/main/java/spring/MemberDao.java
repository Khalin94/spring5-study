package spring;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MemberDao {
	
	private static long id;
	
	private Map<String, Member> saveData = new HashMap<>();
	
	public Member selectByEmail(String email) {
		return saveData.get(email);
	}
	
	public void insert(Member member) {
		member.setId(++id);
		saveData.put(member.getEmail(), member);
	}
	
	public void update(Member member) {
		saveData.put(member.getEmail(), member);
	}
	
	public Collection<Member> selectAll() {
		return saveData.values();
	}

}
