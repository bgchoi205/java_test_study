package com.cbg.exam.app;

import java.util.Scanner;

import com.cbg.exam.app.container.Container;
import com.cbg.exam.app.controller.UsrArticleController;
import com.cbg.exam.app.controller.UsrMemberController;
import com.cbg.exam.app.dto.Member;
import com.cbg.exam.app.session.Session;



public class App {
	
	Scanner sc;
	
	App(){
		
		sc = Container.getSc();
		
	}
	
	public void run() {
		
		System.out.println("==텍스트 게시판 시작==");
		UsrArticleController usrArticleController = new UsrArticleController();
		UsrMemberController usrMemberController = new UsrMemberController();
		Session session = Container.getSession();
		
		while(true) {
			Member loginedMember = (Member)session.getAttribute("loginedMember");
			
			String prompt = "명령어)";
			
			if(loginedMember != null) {
				prompt = loginedMember.nickName + ")";
			}
			
			System.out.printf(prompt);
			
			String command = sc.nextLine().trim();
			
			Rq rq = new Rq(command);
			
			if(rq.getControllerTypeName().equals("usr")) {
				if(rq.getControllerName().equals("article")) {
					usrArticleController.performAction(rq);
				}else if(rq.getControllerName().equals("member")) {
					usrMemberController.performAction(rq);
				}else if(rq.getActionPath().equals("/usr/system/exit")) {
					System.out.println("프로그램 종료");
					break;
				}
				
			}
			
		}
		
		System.out.println("== 텍스트 게시판 끝 ==");
		
	}

	

}

