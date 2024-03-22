package com.shinhan.day06.CH7;

public class Parent2 {
	public String nation;
	
	public Parent2() {
		this("대한민국");
		System.out.println("2. Parent() call");
	}
	
	public Parent2(String nation) {
		//super()	...	Object가 생성된다.
		this.nation = nation;
		System.out.println("1. Parent(String nation) call");
	}
}
