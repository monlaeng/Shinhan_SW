package com.shinhan.day06.CH7;

public class Child2 extends Parent2{
	public String name;
	
	public Child2() {
		//1.default는 super()
		this("홍길동");	//자신의 class의 다른 생성자 호출, 중간불가, 첫 줄만 가능
		System.out.println("4. Child() call");
	}

	public Child2(String name) {
		this.name = name;
		System.out.println("3. Child(String name) call");
	}
}

