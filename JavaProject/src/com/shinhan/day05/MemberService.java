package com.shinhan.day05;

public class MemberService {
	String id;
	String password;
	
	MemberService() {
		id = "hong";
		password = "12345";
	}
	
	boolean login(String id, String password) {
		if(id.equals(this.id) && password.equals(this.password)) {
			return true;
		} 
		return false;	
	}
	boolean login2(String id, String password) {
		return id.equals(this.id) && password.equals(this.password);
	}
	
	
	void logout(String id) {
		System.out.println(id + "님이 로그아웃 되었습니다.");
	}
}
