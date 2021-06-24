package com.cbg.exam.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cbg.exam.app.dto.Article;
import com.cbg.exam.util.Ut;



public class App {
	public static int lastArticleId = 0;
	static ArrayList<Article> articles = new ArrayList<>();
	
	public static void run() {
		
		System.out.println("==텍스트 게시판 시작==");
		
		Scanner sc = new java.util.Scanner(System.in);
		
		while(true) {
			
			System.out.println("명령어)");
			
			String command = sc.nextLine().trim();
			
			if(command.equals("/usr/system/exit")) {
				System.out.println("프로그램 종료");
				break;
			}
			else if(command.equals("/usr/article/write")) {
				
				Article article = new Article();
				Ut ut = new Ut();
				
				System.out.print("제목 입력 : ");
				String title = sc.nextLine().trim();
				System.out.print("내용 입력 : ");
				String body = sc.nextLine().trim();
				
				lastArticleId++;
				
				article.id = lastArticleId;
				article.regDate = ut.getNow();
				article.updateDate = ut.getNow();
				article.title = title;
				article.body = body;
				
				articles.add(article);
				
				System.out.println(article.id + "번 게시물 생성완료");
				
			}
			else if(command.equals("/usr/article/list")) {
				for(Object article : articles) {
					System.out.println(article.toString());
				}
				
			}
			
		}
		
		System.out.println("== 텍스트 게시판 끝 ==");
		
	}

}

