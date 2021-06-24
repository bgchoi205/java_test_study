package com.cbg.exam.app.dto;

public class Article{
	public int id;
	public String regDate;
	public String updateDate;
	public String title;
	public String body;
	
	@Override
	public String toString() {
		return "번호:" + this.id + ", 제목:" + this.title + ", 작성:" + this.regDate;
	}
}
