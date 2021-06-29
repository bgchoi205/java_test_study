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
		
		article.setTitle(title);
		article.setBody(body);
		article.setUpdateDate(Util.getNow());
		
		System.out.println(article.getId() + "번 게시물 수정 완료");
	}




	private void actionDelete(Rq rq) {
		int id = rq.getIntParam("id", 0);
		
		Article article = getArticleById(id, articles);
		
		if(article == null) {
			System.out.println("존재하지 않는 게시물입니다.");
			return;
		}
		articles.remove(article);
		
		System.out.println(id + "번 게시물 삭제완료");
	}




	private void actionDetail(Rq rq) {
		int id = rq.getIntParam("id", 0);
		
		Article article = getArticleById(id, articles);
		
		if(article == null) {
			System.out.println("존재하지 않는 게시물입니다.");
			return;
		}
		System.out.println("번호:" + article.getId());
		System.out.println("등록:" + article.getRegDate());
		System.out.println("수정:" + article.getUpdateDate());
		System.out.println("제목:" + article.getTitle());
		System.out.println("내용:" + article.getBody());
	}




	private void actionList(Rq rq) {
		for(int i = (articles.size() - 1); i >= 0; i--) {
			System.out.println(articles.get(i));
		}
	}




	private void actionWrite(Rq rq) {
		Article article = new Article();
		
		System.out.printf("제목 입력 : ");
		String title = sc.nextLine().trim();
		System.out.printf("내용 입력 : ");
		String body = sc.nextLine().trim();
		
		lastArticleId++;
		
		article.setId(lastArticleId);
		article.setRegDate(Util.getNow());
		article.setUpdateDate(Util.getNow());
		article.setTitle(title);
		article.setBody(body);
		
		articles.add(article);
		
		System.out.println(article.getId() + "번 게시물 생성완료");
	}




	private void makeTestData() {
		for(int i = 1; i <= 10; i++) {
			Article article = new Article();
			
			lastArticleId++;
			
			article.setId(lastArticleId);
			article.setRegDate(Util.getNow());
			article.setUpdateDate(Util.getNow());
			article.setTitle("제목" + i);
			article.setBody("내용" + i);
			
			articles.add(article);
		}
		
	}
	
	private Article getArticleById(int id, List<Article> articles) {
		for(Article a : articles) {
			if(a.getId() == id) {
				Article article = a;
				return article;
			}
		}
		return null;
		
	}

}
