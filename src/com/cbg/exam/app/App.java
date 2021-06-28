package com.cbg.exam.app;

import java.util.ArrayList;
import java.util.Scanner;

import com.cbg.exam.app.dto.Article;
import com.cbg.exam.util.Util;



public class App {
	static int lastArticleId = 0;
	static ArrayList<Article> articles = new ArrayList<>();
	
	public static void run() {
		
		Scanner sc = new java.util.Scanner(System.in);
		
		System.out.println("==텍스트 게시판 시작==");
		
		// test 게시물 생성
		for(int i = 1; i <= 10; i++) {
			Article article = new Article();
			
			String title = "제목" + i;
			String body = "내용" + i;
			
			lastArticleId++;
			
			article.id = lastArticleId;
			article.regDate = Util.getNow();
			article.updateDate = Util.getNow();
			article.title = title;
			article.body = body;
			
			articles.add(article);
		}
		
		
		while(true) {
			
			System.out.println("명령어)");
			
			String command = sc.nextLine().trim();
			
			Rq rq = new Rq(command);
			
			if(rq.getActionPath().equals("/usr/system/exit")) {
				System.out.println("프로그램 종료");
				break;
			}
			else if(rq.getActionPath().equals("/usr/article/write")) {
				
				Article article = new Article();
				
				System.out.print("제목 입력 : ");
				String title = sc.nextLine().trim();
				System.out.print("내용 입력 : ");
				String body = sc.nextLine().trim();
				
				lastArticleId++;
				
				article.id = lastArticleId;
				article.regDate = Util.getNow();
				article.updateDate = Util.getNow();
				article.title = title;
				article.body = body;
				
				articles.add(article);
				
				System.out.println(article.id + "번 게시물 생성완료");
				
			}
			else if(rq.getActionPath().equals("/usr/article/list")) {
				
				for(int i = (articles.size() - 1); i >= 0; i--) {
					System.out.println(articles.get(i));
				}
				
			}
			else if(rq.getActionPath().equals("/usr/article/detail")) {
				String commandBit = command.split("\\?",2)[1];
				String commandBitName = commandBit.split("=")[0];
				int commandBitValue = Integer.parseInt(commandBit.split("=")[1]);
				
				if(!commandBitName.equals("id")) {
					System.out.println("올바른 명령어가 아닙니다.");
					continue;
				}
				
				Article article = null;
				
				for(Article a : articles) {
					if(a.id == commandBitValue) {
						article = a;
						continue;
					}
				}
				if(article == null) {
					System.out.println("존재하지 않는 게시물입니다.");
					continue;
				}
				System.out.println("번호:" + article.id);
				System.out.println("등록:" + article.regDate);
				System.out.println("수정:" + article.updateDate);
				System.out.println("제목:" + article.title);
				System.out.println("내용:" + article.body);
			}
			else if(rq.getActionPath().equals("/usr/article/delete")) {
				String commandBit = command.split("\\?",2)[1];
				String commandBitName = commandBit.split("=")[0];
				int commandBitValue = Integer.parseInt(commandBit.split("=")[1]);
				
				if(!commandBitName.equals("id")) {
					System.out.println("올바른 명령어가 아닙니다.");
					continue;
				}
				
				Article article = null;
				
				for(Article a : articles) {
					if(a.id == commandBitValue) {
						article = a;
						continue;
					}
				}
				if(article == null) {
					System.out.println("존재하지 않는 게시물입니다.");
					continue;
				}
				articles.remove(article);
				
				System.out.println(article.id + "번 게시물 삭제완료");
				
			}
			
			
		}
		
		System.out.println("== 텍스트 게시판 끝 ==");
		
	}

}

