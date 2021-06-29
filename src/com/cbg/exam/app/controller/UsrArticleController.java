package com.cbg.exam.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cbg.exam.app.Rq;
import com.cbg.exam.app.container.Container;
import com.cbg.exam.app.dto.Article;
import com.cbg.exam.util.Util;

public class UsrArticleController {
	private int lastArticleId;
	private List<Article> articles;
	private Scanner sc;
	
	public UsrArticleController(){
		lastArticleId = 0;
		articles = new ArrayList<>();
		sc = Container.getSc();
		
		// test 데이터 생성
		makeTestData();
		
	}
	
	
	

	public void performAction(Rq rq) {
		
		if(rq.getActionPath().equals("/usr/article/write")) {
			actionWrite(rq);
		}
		else if(rq.getActionPath().equals("/usr/article/list")) {
			actionList(rq);
		}
		else if(rq.getActionPath().equals("/usr/article/detail")) {
			actionDetail(rq);
		} else if(rq.getActionPath().equals("/usr/article/delete")) {
			actionDelete(rq);
		} else if(rq.getActionPath().equals("/usr/article/modify")) {
			actionModify(rq);
		}
		
	}
	
	private void actionModify(Rq rq) {
		int id = rq.getIntParam("id", 0);
		
		Article article = getArticleById(id, articles);
		
		if(article == null) {
			System.out.println("존재하지 않는 게시물입니다.");
			return;
		}
		System.out.printf("제목 입력 : ");
		String title = sc.nextLine().trim();
		System.out.printf("내용 입력 : ");
		String body = sc.nextLine().trim();
		
		article.title = title;
		article.body = body;
		article.updateDate = Util.getNow();
		
		System.out.println(article.id + "번 게시물 수정 완료");
	}




	private void actionDelete(Rq rq) {
		int id = rq.getIntParam("id", 0);
		
		Article article = getArticleById(id, articles);
		
		if(article == null) {
			System.out.println("존재하지 않는 게시물입니다.");
			return;
		}
		articles.remove(article);
		
		System.out.println(article.id + "번 게시물 삭제완료");
	}




	private void actionDetail(Rq rq) {
		int id = rq.getIntParam("id", 0);
		
		Article article = getArticleById(id, articles);
		
		if(article == null) {
			System.out.println("존재하지 않는 게시물입니다.");
			return;
		}
		System.out.println("번호:" + article.id);
		System.out.println("등록:" + article.regDate);
		System.out.println("수정:" + article.updateDate);
		System.out.println("제목:" + article.title);
		System.out.println("내용:" + article.body);
	}




	private void actionList(Rq rq) {
		for(int i = (articles.size() - 1); i >= 0; i--) {
			System.out.println(articles.get(i));
		}
	}




	private void actionWrite(Rq rq) {
		
		System.out.printf("제목 입력 : ");
		String title = sc.nextLine().trim();
		System.out.printf("내용 입력 : ");
		String body = sc.nextLine().trim();
		
		lastArticleId++;
		
		int id = lastArticleId;
		String regDate = Util.getNow();
		String updateDate = Util.getNow();
		
		Article article = new Article(id, regDate, updateDate, title, body);
		
		articles.add(article);
		
		System.out.println(article.id + "번 게시물 생성완료");
	}




	private void makeTestData() {
		for(int i = 1; i <= 10; i++) {
			
			lastArticleId++;
			
			int id = lastArticleId;
			String regDate = Util.getNow();
			String updateDate = Util.getNow();
			
			Article article = new Article(id, regDate, updateDate, "제목" + i, "내용" + i);
			
			articles.add(article);
		}
		
	}
	
	private Article getArticleById(int id, List<Article> articles) {
		for(Article a : articles) {
			if(a.id == id) {
				Article article = a;
				return article;
			}
		}
		return null;
		
	}

}
