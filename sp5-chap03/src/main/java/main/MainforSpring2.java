package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig1;
import config.AppConfig2;
import spring.ChangePasswordService;
import spring.DuplicateMemberException;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberNotFoundException;
import spring.MemberRegisterService;
import spring.RegisterRequest;
import spring.VersionPrinter;
import spring.WrongIdPasswordException;

public class MainforSpring2 {
	
	private static AnnotationConfigApplicationContext ctx = null;
	
	public static void main(String[] args) throws IOException{
		ctx =  new AnnotationConfigApplicationContext(AppConfig1.class, AppConfig2.class);

		/*	
		AbstractApplicationContext aac = new AnnotationConfigApplicationContext(AppConfig1.class, AppConfig2.class);
		AppConfig1 appConfig1 = aac.getBean(AppConfig1.class);
		System.out.println(appConfig1 != null);
	 	*/

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("명령어를 입력하세요.");
			String command = reader.readLine();
			if(command.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			if(command.startsWith("new ")) {
				processNewCommand(command.split(" "));
				continue;
			}else if(command.startsWith("change ")) {
				processChangeCommand(command.split(" "));
				continue;
			}else if(command.equals("list")) {
				processListCommand();
				continue;
			}else if(command.startsWith("info ")) {
				processInfoCommand(command.split(" "));
				continue;
			}else if(command.equals("version")) {
				processVersionCommand();
				continue;
			}
			printHelp();
		}
	}
	
	private static void processNewCommand(String[] arg	) {
		if(arg.length != 5) {
			printHelp();
			return;
		}
		MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
		RegisterRequest req = new RegisterRequest();
		req.setEmail(arg[1]);
		req.setName(arg[2]);
		req.setPassword(arg[3]);
		req.setConfirmPassword(arg[4]);
		
		if(!req.isPasswordEqualsToConfirmPassword()) {
			System.out.println("비밀번호와 확인이 일치하지 않습니다.");
			return;
		}
		
		try {
			regSvc.regist(req);
			System.out.println("회원을 등록했습니다.");
		}catch(DuplicateMemberException e) {
			System.out.println("이미 존재하는 회원입니다.");
		}
	}
	
	private static void processChangeCommand(String[] arg) {
		if(arg.length != 4) {
			printHelp();
			return;
		}
		
		ChangePasswordService changePwdSvc = ctx.getBean("changePwdSvc", ChangePasswordService.class);
		
		try {
			changePwdSvc.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("비밀번호 변경");
		}catch(MemberNotFoundException e) {
			System.out.println("존재하지 않는 회원입니다.");
		}catch(WrongIdPasswordException e) {
			System.out.println("아이디와 비밀번호가 일치하지 않습니다.");
		}
	}
	
	private static void processListCommand() {
		MemberListPrinter listPrinter = ctx.getBean("listPrinter", MemberListPrinter.class);
		listPrinter.printAll();
	}
	
	private static void  processInfoCommand(String[] arg) {
		if(arg.length != 2) {
			printHelp();
			return;
		}
		MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		infoPrinter.printMemberInfo(arg[1]);
	}
	
	private static void processVersionCommand() {
		VersionPrinter versionPrinter = ctx.getBean("versionPrinter", VersionPrinter.class);
		versionPrinter.print();
	}
	
	private static void printHelp() {
		System.out.println();
		System.out.println("잘못된 명령어입니다.");
		System.out.println("new 이메일 이름 비밀번호 비밀번호확인");
		System.out.println("change 이메일 현재비밀번호 변경비밀번호");
		System.out.println();
	}
}
