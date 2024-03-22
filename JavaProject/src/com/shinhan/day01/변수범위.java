package com.shinhan.day01;

//1. 하나의 .java 파일에 여러개의 class가 올 수 있다.
public class 변수범위 {
	//1.멤버변수
	//static 메서드에서 non-static 변수를 사용불가 (메모리에 올라오지 않음)
	static String model;	//null 정의된 값이 없음을 의미
	static int price;
	public static void main(String[] args) {
		f2();

	}
	private static void f2() {
		//1. 변수선언
		int a; // a는 int를 무대했다.
		Car c1, c2; //c1은 Car를 담을 수 있다
		//2. 객체생성
		a=100; //기본형은 100을 a에 저장한다.
		c1 = new Car();
		c2 = new Car();

		System.out.println();
		
		//3. 객체생성
	}
	private static void f1() {
		//함수 내의 변수는 지역변수이다. 반드시 초기화 후에 사용한다.
		int a = 100;
		System.out.println("a=" + a);
		System.out.println("멤버변수접근 model=" + model);
		System.out.println("멤버변수접근 price" + price);
	}

}

//class : 이 objet
//class : 변수(data 저장) + 메서드(기능)
class Car {
	String model;
	int price;
	
	void drive() {
		System.out.println(model + ":" + price);
	}
}