package com.shinhan.day05;

public class Book {
	//1.field
	//class 변수
	static int bookCount;
	//instatne 변수
	String title;
	int price;
	
	//final
	final String publish = " 한빛미디어";
	final String publish2;
	final String publish3;
	
	//상수(불변), 대문자로 선언
	//1) 선언 시 초기화, 2) stastic block 초기화
	static final String ISBN = "1234-5678";
	static final String ISBN2;
	static {
		ISBN2 = "8888-9999";
	}
	
	//2.construcotor	
	Book() {
		System.out.println("default 생성자를 정의한다.");
		
		this.publish2 = "default생성자에서 초기화됨";
	}
	Book(String publish2) {
		this.publish2 = publish2;
	}
	{
		publish3 = "한빛미디어3";
	}
	//3.method
	//4.block;
	//5.inner lass
}
