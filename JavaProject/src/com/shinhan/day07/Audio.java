package com.shinhan.day07;

public class Audio implements RemoteController {

	int a = 100;
	static int b = 200;
	public Audio() {
		System.out.println("Audio default 생성자");
	}
	void show() {
		System.out.println("");
	}
	public void method1() {
		System.out.println("Audio method1() 구현");
	}
	public void method2() {
		System.out.println("Audio method2() 구현");
	}
	public void turnOn() {
		System.out.println("Audio turnOn() 구현");
	}
	public void turnOff() {
		System.out.println("Audio turnOff() 구현");
	}
	
}
