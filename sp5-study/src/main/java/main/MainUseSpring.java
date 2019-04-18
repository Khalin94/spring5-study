package main;

import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfigWithExclude;
import config.AppCtx;
import config.Config2;
import config.ConfigImport;
import config.Config1;
import spring.ChangePasswordService;
import spring.DuplicateException;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberNotFoundException;
import spring.MemberRegisterService;
import spring.RegisterRequest;
import spring.SamePasswordException;
import spring.WrongIdPasswordException;

public class MainUseSpring {
	
	private static ApplicationContext ctx = null;
			
	public static void main(String[] args) {
//		ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		ctx = new AnnotationConfigApplicationContext(AppConfigWithExclude.class);
		// 설정파일 두 개 사용시! AnnotationConfigApplicationContext는 가변인자임.
//		ctx = new AnnotationConfigApplicationContext(ConfigImport.class);
		//ctx = new AnnotationConfigApplicationContext(Config1.class, Config2.class);
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("명령어를 입력하세요");
			String command = sc.nextLine();
			
			if(command.startsWith("new ")) {
				newMember(command.split(" "));
				continue;
			}else if(command.startsWith("change ")) {
				changePassword(command.split(" "));
				continue;
			}else if(command.equals("exit")) {
				System.out.println("시스템 종료");
				break;
			}else if(command.equals("help")) {
				printHelp();
				continue;
			}else if(command.equals("list")) {
				printList();
				continue;
			}else if(command.startsWith("info ")) {
				memberInfo(command.split(" "));
				continue;
			}
		}
		sc.close();
	}

	private static void newMember(String[] args) {
		if(args.length != 5) {
			System.out.println("잘못된 사용법입니다.");
			printHelp();
			return;
		}
		//MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
		MemberRegisterService regSvc = ctx.getBean(MemberRegisterService.class);
		RegisterRequest req = new RegisterRequest();
		req.setEmail(args[1]); req.setName(args[2]); req.setPassword(args[3]); req.setConfirmPassword(args[4]);
		
		if(!req.isPasswordEqualsToComfirm()) {
			System.out.println("비밀번호와 확인이 같지 않습니다.");
			return;
		}
		try {
			regSvc.register(req);
			System.out.println("회원등록이 완료되었습니다.");
		}catch (DuplicateException e) {
			System.out.println("이미 등록된 회원입니다.");
			return;
		}
		
	}
	
	private static void changePassword(String[] args) {
		if(args.length != 4) {
			printHelp();
			return;
		}
		
//		ChangePasswordService changePwdSvc = ctx.getBean("changePwdSvc", ChangePasswordService.class);
		ChangePasswordService changePwdSvc = ctx.getBean(ChangePasswordService.class);
		
		try {
			changePwdSvc.changePassword(args[1], args[2], args[3]);
			System.out.println("비밀번호가 변경되었습니다.");
		}catch(MemberNotFoundException e) {
			System.out.println("회원이 존재하지 않습니다.");
		}catch(SamePasswordException e) {
			System.out.println("같은 비밀번호를 사용할 수 없습니다.");
		}catch(WrongIdPasswordException e) {
			System.out.println("아이디와 비밀번호가 일치하지 않습니다.");
		}
	}
	
	private static void printList() {
		//MemberListPrinter listPrinter = ctx.getBean("listPrinter", MemberListPrinter.class);
		MemberListPrinter listPrinter = ctx.getBean(MemberListPrinter.class);
		listPrinter.printAll();
	}
	
	private static void memberInfo(String[] args) {
		if(args.length != 2) {
			printHelp();
			return;
		}
		//MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		infoPrinter.printInfo(args[1]);
	}
	
	private static void printHelp() {
		System.out.println("=================");
		System.out.println("new 사용법");
		System.out.println("new email name password passwordconfirm");
		System.out.println("change 사용법");
		System.out.println("change email oldPassword newPassword");
		System.out.println("=================");
	}

}
