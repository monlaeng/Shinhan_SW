package com.shinhan.day07;

//interface를 구현한 class
//추상메서드를 반드시 구현할 의무가 있다.
public class Television extends Object implements RemoteController{

	public void method1() {
		System.out.println(getClass().getSimpleName());
	}
	public void method2() {
		System.out.println(getClass().getSimpleName());

	}
	public void TurnOn() {
		System.out.println(getClass().getSimpleName());

	}
	public void TurnOff() {
		System.out.println(getClass().getSimpleName());
		
	}
	//default 메서드는 재정의 가능
	public void method3() {
		RemoteController.super.method3();
		System.out.println("default 메서드 재정의함");
	}
	void method4() {
		System.out.println("메서드 불가능");
		Television aa = new Television();
		aa.method4();
		
	}
	
}
