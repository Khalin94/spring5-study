package spring;

import java.time.LocalDateTime;

public class Member {

	private Long id;
	private String email;
	private String password;
	private String name;
	private LocalDateTime regDate;
	
	public Member(String email, String password, String name, LocalDateTime regDate) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.regDate = regDate;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	
	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}
	
	public LocalDateTime getRegDate() {
		return regDate;
	}
	
	public void changePassword(String oldPwd, String newPwd) {
		if(!password.equals(oldPwd)) {
			throw new WrongIdPasswordException();
		}
		this.password = newPwd;
	}
}
	

