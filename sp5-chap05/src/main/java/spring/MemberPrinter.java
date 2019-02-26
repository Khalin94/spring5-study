package spring;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

public class MemberPrinter {
	
	private DateTimeFormatter dateTimeFormatter;
	
	public MemberPrinter() {
		dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
	}

	public void print(Member member) {
		if(dateTimeFormatter == null) {
			System.out.printf("회원 정보 : 아이디 = %d, 이메일 = %s, 이름 = %s, 등록일 = %tF\n",
					member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime());
		}else {
			System.out.printf("회원 정보 : 아이디 = %d, 이메일 = %s, 이름 = %s, 등록일 = %s\n",
					member.getId(), member.getEmail(), member.getName(), dateTimeFormatter.format(member.getRegisterDateTime()));
		}
	}
	
	// required를 false로 사용함으로써 Autowired가 찾는 빈 객체가 없더라도 에러를 발생시키지 않음.
	@Autowired(required = false)
	public void setDateFormatter(DateTimeFormatter dateTimeFormatter) {
		this.dateTimeFormatter = dateTimeFormatter;
	}
	
	
	/* Optional을 사용하여 일치하는 빈이 없으면 값이 없는 Optional을 인자로 전달(exception 발생 안함)
	 * 빈이 존재하면 빈 값을 갖는 Optional을 인자로 전달
	@Autowired
	public void setDateFormatter(Optional<DateTimeFormatter> formatterOpt) {
		if(formatterOpt.isPresent()) {
			this.dateTimeFormatter = formatterOpt.get();
		}else {
			this.dateTimeFormatter = null;
		}
	}
	*/

	/*
	 * Nullable 애노테이션을 의존주입 대상 파라미터에 붙이면 자동 주입할 빈이 있으면 해당 빈을
	 * 인자로 전달하고 없으면 null을 전달 한다.
	@Autowired
	public void setDateFormatter(@Nullable DateTimeFormatter dateTimeFormatter) {
		this.dateTimeFormatter = dateTimeFormatter;
	}
	 */
/*
	public void print(Member member) {
		System.out.printf("회원 정보 : 아이디 = %d, 이메일 = %s, 이름 = %s, 등록일 = %tF \n",
				member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime());
	}
	*/
}
