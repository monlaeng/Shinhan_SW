package com.shinhan.day01;

/*
 * > javac 연산자연습.java => 연산자연습.class
 * > java 연산자연습 실행한다.
 * 1. 연산자연습.class가 메모리에 올라온다.
 * 2. 검증
 * 3. main 시작
 * 4. main 끝
 */

public class 연산자연습 {

	public static void main(String[] args) {
		f4(); //f1이라는 이름의 함수를 호출한다.
	}	
	private static void f4() {
		int java = 100;
		int sql = 99;
		int web = 97;
		int count = 3;
		int total = java + sql + web;
		double avg = total / 3.0;
		double avg2 = (double)total/count;
		System.out.println("총점:" + total);
		System.out.println("평균:" + avg);
		System.out.println("평균:" + avg2);
	}
	private static void f3() {
		int a = 10;
		double b = 20.5f;	//자동형변환
		double c = a+b;	//자동형변환 int타입 a가 -> double
		int d = (int) (a+b);	//강제형변환
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		System.out.println("c=" + c);
		System.out.println("d=" + d);
	}
	private static void f2() {
		float a = 10.5f;
		double b = 20.5f;	//자동형변환
		double c = a+b;	//피연산자를 무조건 int로 형변환한다.
		float d = (float) (a+b);	//강제형변환
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		System.out.println("c=" + c);
		System.out.println("d=" + d);
	}

	private static void f1() {
		byte a = 10;
		byte b = 20;
		byte c =(byte) (a+b);	//피연산자를 무조건 int로 형변환한다.
		int d = a+b;
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		System.out.println("c=" + c);
		System.out.println("d=" + d);
	}

}

class FirstZone {
	
}
