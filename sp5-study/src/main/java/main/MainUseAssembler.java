package main;

import java.util.Scanner;

import assembler.Assembler;
import spring.ChangePasswordService;
import spring.DuplicateException;
import spring.MemberNotFoundException;
import spring.MemberRegisterService;
import spring.RegisterRequest;
import spring.SamePasswordException;
import spring.WrongIdPasswordException;

public class MainUseAssembler {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("명령어를 입력하세요");
			String command = sc.nextLine();
			if(command.equals("exit")) {
				System.out.println("시스템 종료");
				break;
			}
			if(command.startsWith("new ")) {
				RegisterMember(command.split(" "));
				continue;
			}
			if(command.startsWith("change ")) {
				changePassword(command.split(" "));
				continue;
			}
			if(command.equals("help")) {
				printHelp();
				continue;
			}
		}
		sc.close();
	}
	
	static Assembler assembler = new Assembler();

	private static void RegisterMember(String[] command) {
		if(command.length != 5) {
			printHelp();
			return;
		}
		
				
		MemberRegisterService RegSvc = assembler.getMemberRegisterService();
		RegisterRequest req = new RegisterRequest();
		req.setEmail(command[1]);
		req.setName(command[2]);
		req.setPassword(command[3]);
		req.setConfirmPassword(command[4]);
		
		if(!req.isPasswordEqualsToComfirm()) {
			System.out.println("비밀번호와 확인이 일치하지 않습니다.");
			return;
		}
		try {
			RegSvc.register(req);
			System.out.println("등록완료!");
		}catch(DuplicateException e) {
			System.out.println("이미 등록된 회원입니다.");
			return;
		}
	}
	
	private static void changePassword(String[] command) {
		if(command.length != 4) {
			printHelp();
			return;
		}
		
		ChangePasswordService changePwdSvc = assembler.getChangePasswordService();
		try {
			changePwdSvc.changePassword(command[1], command[2], command[3]);
			System.out.println("비밀번호를 변경했습니다.");
		}catch(MemberNotFoundException e) {
			System.out.println("존재하지 않는 회원입니다.");
		}catch(WrongIdPasswordException e) {
			System.out.println("아이디와 비밀번호가 일치하지 않습니다.");
		}catch(SamePasswordException e) {
			System.out.println("같은 비밀번호를 사용할 수 없습니다.");
		}

	}
	
	private static void  printHelp() {
		System.out.println("==============");
		System.out.println("new 명령어 사용법");
		System.out.println("new Email name password passwordConfirm");
		System.out.println("change 명령어 사용법");
		System.out.println("change Email oldPassword newPassword");
		System.out.println("==============");
	}
}
