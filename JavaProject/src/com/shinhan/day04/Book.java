package com.shinhan.day04;

//class : object를 만들기 위한 틀(template), 설계도
//object : class를 이용해서 만든 독립적 실체(instance)
public class Book {

	//1.field(변수,data 저장목적, 특징)
	String title;
	int price;
	//2.constructor(생성자메서드) : argument가 없는 기본생성자는 컴파일 시에 만들어진다.
	//class이름과 같아야한다. return 사용불가
	//생성자를 추가가능...추가하면 컴파일 시에 생성자를 만들지않는다.
	
	//Overloading : 이름은 같고 매개변수 사양이 다르다.
	//this : 현재객체
	//매개변수이름과 field 이름이 충돌발생 시 구분하기 위해 사용한다.
	//같은 이름의 다른모양의 생성자를 호출하기 : this();
	Book() {
		this(null,0);
	}
	
	Book(String title, int price) {
		System.out.println("argument 2개 생성자");
		this.title = title;
		this.price = price;
	}
	
	Book(String title) {
		this(title, 50000);
	}
	Book(int price) {
		this("제목모름", price);
	}
	//3.method(함수, 기능) : 반드시 return type을 정의한다. return 값이 없으면 void 사용
	void bookInfoPrint() {
		System.out.println("===책의 정보===");
		System.out.println("제목 : " + title);
		System.out.println("가격 : " + price);
		
	}
	//4.block
	{
		System.out.println("block...object 생성 시마다 수행");
	}
	static {
		System.out.println("class load시에 1회 수행");
	}

	//5.inner class	
	class AA{
		
	}
}
