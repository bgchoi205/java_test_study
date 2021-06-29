package com.cbg.exam.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cbg.exam.app.Rq;
import com.cbg.exam.app.container.Container;
import com.cbg.exam.app.dto.Article;
import com.cbg.exam.app.dto.Member;
import com.cbg.exam.util.Util;

public class UsrMemberController {
	
	private int lastMemberId;
	private List<Member> members;
	private Scanner sc;
	
	public UsrMemberController(){
		lastMemberId = 0;
		members = new ArrayList<>();
		sc = Container.getSc();
		
		// test 데이터 생성
		makeTestData();
		
	}
	

	public void performAction(Rq rq) {
		
		if(rq.getActionPath().equals("/usr/member/login")) {
			actionLogin(rq);
		}
		
		
	}
	
	
	private void actionLogin(Rq rq) {
		
		System.out.printf("로그인 아이디 입력 : ");
		String loginId = sc.nextLine().trim();
		
		if(loginId.length() == 0) {
			System.out.println("아이디를 입력해주세요.");
			return;
		}
		
		System.out.printf("로그인 비밀번호 입력 : ");
		String loginPw = sc.nextLine().trim();
		
		Member member = getMemberByLoginId(loginId);
		
		if(member == null) {
			System.out.println("존재하지 않는 아이디입니다.");
			return;
		}
		if(member.loginPw.equals(loginPw) == false) {
			System.out.println("비밀번호가 틀립니다.");
			return;
		}
		
		rq.setSessionAttr("loginedMember", member);
		
		System.out.println(member.nickName + "님 환영합니다.");
		
	}


	private Member getMemberByLoginId(String loginId) {
		for(Member member : members) {
			if(member.loginId.equals(loginId)) {
				return member;
			}
		}
		return null;
	}


	private void makeTestData() {
		for(int i = 1; i <= 5; i++) {
			
			lastMemberId++;
			
			int id = lastMemberId;
			String regDate = Util.getNow();
			String updateDate = Util.getNow();
			
			
			Member member = new Member(id, regDate, updateDate, "user" + i, "user" + i, "철수" + i, "사용자" + i);
			
			members.add(member);
		}
		
	}
}
