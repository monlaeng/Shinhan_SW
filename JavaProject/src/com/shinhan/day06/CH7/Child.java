package com.shinhan.day06.CH7;

public class Child extends Parent{
	public int studentsNo;
	
	public Child(String name, int studentsNo) {
		//default는 부모의 default 생성자를 호출한다.
		//1. 부모가 default 생성자 가진다.
		//super();
		//2.명시적으로 부모의 생성자를 호출한다.
		super(name);
		this.studentsNo = studentsNo;
	}
}
