package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import spring.ChangePasswordService;
import spring.DuplicateMemberException;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberNotFoundException;
import spring.MemberRegisterService;
import spring.RegisterRequest;
import spring.WrongIdPasswordException;

public class Main {
	
	private static AnnotationConfigApplicationContext ctx =null;
	
	public static void main(String[] args) throws IOException{
		
		ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("명령어를 입력하세요 : ");
			String command = reader.readLine();
			if(command.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			if(command.startsWith("new ")) {
				processNewCommand(command.split(" "));
			}else if(command.startsWith("change ")) {
				processChangeCommand(command.split(" "));
			}else if(command.equals("list")) {
				processListCommand();
			}else if(command.startsWith("info ")) {
				processInfoCommand(command.split(" "));
			}else {
				printHelp();
			}
		}
		ctx.close();
	}
	
	private static void processNewCommand(String[] args) {
		if(args.length != 5) {
			printHelp();
			return;
		}
		MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
		RegisterRequest req = new RegisterRequest();
		req.setEmail(args[1]);
		req.setName(args[2]);
		req.setPassword(args[3]);
		req.setConfirmPassword(args[4]);
		
		if(!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("비밀번호와 확인이 일치하지 않습니다.");
			return;
		}
		try {
			regSvc.regist(req);
			System.out.println("등록을 완료하였습니다.");
		}catch(DuplicateMemberException e) {
			System.out.println("이미 존재하는 이메일입니다.");
		}
	}
	
	private static void processChangeCommand(String[] args) {
		if(args.length != 4) {
			printHelp();
			return;
		}
		
		ChangePasswordService changePwdSvc = ctx.getBean("changePwdSvc", ChangePasswordService.class);
		
		try {
			changePwdSvc.changePassword(args[1], args[2], args[3]);
			System.out.println("비밀번호 변경 완료");
		}catch(MemberNotFoundException e) {
			System.out.println("존재하지 않는 이메일입니다.");
		}catch(WrongIdPasswordException e) {
			System.out.println("비밀번호가 일치하지 않습니다.");
		}
	}
	
	private static void processListCommand() {
		
		MemberListPrinter listPrinter = ctx.getBean("listPrinter", MemberListPrinter.class);
		listPrinter.printAll();
		
	}
	
	private static void processInfoCommand(String[] args) {
		if(args.length != 2) {
			printHelp();
			return;
		}
		
		MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		infoPrinter.printMemberInfo(args[1]);
	}
	
	private static void printHelp() {
		System.out.println("잘못된 명령어입니다.");
		System.out.println("new email name password passwordConfirm");
		System.out.println("change email oldPassword newPassword");
		System.out.println();
	}
}
