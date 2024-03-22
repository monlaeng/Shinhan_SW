package com.shinhan.day07;

//두 객체를 연결하는 역할
//정의는 있고 구현은 없다.(규격서)
//interface를 구현한 class를 만들어 함수를 구현한다. (만약 10개 구현 class 만듦)
public interface RemoteController {

	//1.상수
	int CHANNER = 10;
	public static final int CHANNER2=10;
	
	//2.추상메서드
	void method1();
	public abstract void method2();
	void turnOn();
	void turnOff();
	
	//3.default 메서드(구현 class가 공통적으로 가지는 기능을 구현, 재정의가능)
	default void method3() {
		System.out.println("default method... 재정의 가능");
		method5();
	}
	
	//4.static 메서드(interface가 가지는 기능, 구현 class가 재정의 불가능
	static void method4() {
		System.out.println("static method...재정의 불가능");
	}
	
	//5.private 메서드(interface 내에서 모듈화 또는 재사용을 위해 사용
	private void method5() {
		System.out.println("private method...");
	}
	
	//일반메서드 불가
	
}