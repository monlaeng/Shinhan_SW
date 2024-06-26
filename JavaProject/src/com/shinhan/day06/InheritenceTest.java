package com.shinhan.day06;

class Parent extends Object {
	String title = "부모에서 정의함";
	private String title2 = "부모에서 정의한.private";
	Parent() {
		//super(); 자동으로 부모의 default 생성자를 호출한다
		System.out.println("부모의 default 생성자");
	}
	void show() {
		System.out.println("부모에서 정의한 show 메서드....");
		System.out.println("부모에서 정의한 show 메서드....");
	}
	private void print() {
		System.out.println("부모에서 정의된 show메서드 ... title: " + title);
		System.out.println("부모에서 정의된 show메서드 ... title2: " + title2);
	}
}

class Child extends Parent{
	int title = 200;
	int score = 100;
	Child() {
		//super(); 자동으로 부모의 default 생성자를 호출한다.
		System.out.println("자식의 default 생성자");
	}
	void show2() {
		System.out.println("자식에서 정의한 show2 메서드");
		System.out.println("자식에서 출력...score.title :"  + title);
//		System.err.println("부모 private로 정의된 field 접근불가 " + title2);
		show();	//private 인 print는 불가능
	}
}



public class InheritenceTest {

	public static void main(String[] args) {
		f1();

	}

	private static void f1() {
		Child ch1 = new Child();
		System.out.println(ch1.score);
		System.out.println(ch1.title);
		ch1.show();
		ch1.show2();
	}

}
