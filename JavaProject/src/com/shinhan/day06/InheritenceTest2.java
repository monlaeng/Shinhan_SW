package com.shinhan.day06;

import javax.swing.plaf.synth.SynthOptionPaneUI;

//Object는 최상위 claass.
class Parent2 extends Object{
	int score = 100;
	void show() {
		System.out.println("3.부모에서 score 접근 " + score);
	}
}
class Child2 extends Parent2{
	//Override(덮어쓰기) : 이름, 매개변수, return, modifier
	void show() {
		System.out.println("2.!!!!!!자식에서 score 접근 :" + score);
	}
	//Overloading(추가) : 이름은 같고 매개변수 사양이 다르다.
	void show(String a) {
		System.out.println("1. ===========");
		//자신의 class에 재정의되어있으면 메서드 수행
		show();
		//super는 부모를 의미
		super.show();
		System.out.println("4.!!!!!!자식에서 score 접근 :" + score);
	}
	void print() {
		System.out.println("자식이 score 접근 : " + score);
		show();
	}
	void f() {
		System.out.println(score);
	}
}

public class InheritenceTest2 {

	public static void main(String[] args) {
		Child2 aa = new Child2();	//Object 생성, Parent2 생성, Child2 생성
		System.out.println(aa.score);
		aa.print();
		aa.show();
		aa.show("**********");
	}

}
