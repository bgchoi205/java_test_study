package com.cbg.exam.app;

import java.util.Scanner;

import com.cbg.exam.app.container.Container;
import com.cbg.exam.app.controller.UsrArticleController;



public class App {
	
	Scanner sc;
	
	App(){
		
		sc = Container.getSc();
		
	}
	
	public void run() {
		
		System.out.println("==텍스트 게시판 시작==");
		UsrArticleController usrArticleController = new UsrArticleController();
		
		while(true) {
			
			System.out.println("명령어)");
			
			String command = sc.nextLine().trim();
			
			Rq rq = new Rq(command);
			
			if(rq.getControllerTypeName().equals("usr")) {
				if(rq.getControllerName().equals("article")) {
					usrArticleController.performAction(rq);
				}else if(rq.getActionPath().equals("/usr/system/exit")) {
					System.out.println("프로그램 종료");
					break;
				}
				
			}
			
		}
		
		System.out.println("== 텍스트 게시판 끝 ==");
		
	}

	

}

