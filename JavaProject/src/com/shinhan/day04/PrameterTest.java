package com.shinhan.day04;

public class PrameterTest {
	public static void main(String[] args) {
		sum(10, 20);
		sum(10,20 ,30);	//자동 형변환 ==> 실수 3으로 간다.
		sum(10,20 ,30, 40);
		sum(10,20 ,30,40, 50);
		sum(10,20 ,30, 40, 50, 60);
		int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		sum(values);
		sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		sum("자바", "프로그램");
		sum(3.14, 10.5, 20.5);
	}
	}
	
	 //멤버메서드 : 객체 생성 후 호출 가능하다.
	//static은 static에서만 호출가능하다.
	private static void sum(int i, int j) {
		System.out.println("정수합2" + (i+j));
	}
	private static void sum2(int i, int j) {
		System.out.println("정수합2" + (i+j));
	}
	private static void sum3(int i, int j) {
		System.out.println("정수합3" + (i+j));
	}
	private static void sum3(String s1, String s2) {
		System.out.println("문자 2 ; " + s2);
	}
	//메서드 Overloading : 메서드 이름은 길고 매개변수 사양은 다르다.
	private static void sum(int...datas) {
		int total = 0;
		for(int data:datas) {
			total+=data;
		}
		System.out.println("가변길이 매개변수" + total);
	}
	
	void print() {
		sum(1.2);
	}
}
