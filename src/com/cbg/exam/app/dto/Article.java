package com.cbg.exam.app.dto;

import lombok.Data;

@Data
public class Article{
	private int id;
	private String regDate;
	private String updateDate;
	private String title;
	private String body;
	
	@Override
	public String toString() {
		return "번호:" + this.id + ", 제목:" + this.title + ", 작성:" + this.regDate;
	}
	
//	public Article(int id, String regDate, String updateDate, String title, String body){
//		this.id = id;
//		this.regDate = regDate;
//		this.updateDate = updateDate;
//		this.title = title;
//		this.body = body;
//	}
}
