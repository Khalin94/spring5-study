package spring;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MemberPrinter {
	private DateTimeFormatter dateTimeformatter;
	
	/*public void print(Member member) {
		System.out.printf("회원 정보 : 이메일 = %s, 이름 = %s, 비밀번호 = %s\n", member.getEmail(), member.getName(), member.getPassword());
	}*/
	/*public MemberPrinter() {
		dateTimeformatter = DateTimeFormatter.ofPattern("yyyy MM dd");
	}*/

	public void print(Member member) {
		if(dateTimeformatter == null) {
			System.out.printf("회원 정보 : 아이디 = %d, 이메일 = %s, 이름 = %s, 등록일 = %tF\n",
					member.getId(), member.getEmail(), member.getName(), member.getRegDate());
		}else {
			System.out.printf("회원 정보 : 아이디 = %d, 이메일 = %s, 이름 = %s, 등록일 = %tF\n",
					member.getId(), member.getEmail(), member.getName(), dateTimeformatter.format(member.getRegDate()));
		}
	}
	
	@Autowired(required = false)
	public void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
		this.dateTimeformatter = dateTimeFormatter;
	}
	
	//@Nullable을 이용한 자동주입 필수 지정
	/*@Autowired
	public void setDateTimeFormatter(@Nullable DateTimeFormatter dateTimeFormatter) {
		this.dateTimeformatter = dateTimeFormatter;
	}*/

	//optional을 이용한 자동주입 필수 지정
	/*@Autowired
	public void setDateTimeFormatter(Optional<DateTimeFormatter> formatterOpt) {
		if(formatterOpt.isPresent()) {
			this.dateTimeformatter = formatterOpt.get();
		}else {
			this.dateTimeformatter = null;
		}
	}*/

}
