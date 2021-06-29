package com.cbg.exam.app.dto;

import lombok.Data;

@Data
public class Member {
	public int id;
	public String regDate;
	public String updateDate;
	public String loginId;
	public String loginPw;
	public String name;
	public String nickName;
	
//	public Member(int id, String regDate, String updateDate, String loginId, String loginPw, String name, String nickName) {
//		this.id = id;
//		this.regDate = regDate;
//		this.updateDate = updateDate;
//		this.loginId = loginId;
//		this.loginPw = loginPw;
//		this.name = name;
//		this.nickName = nickName;
//	}
}
