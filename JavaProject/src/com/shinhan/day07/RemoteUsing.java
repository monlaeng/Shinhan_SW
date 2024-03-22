package com.shinhan.day07;

public class RemoteUsing {
	public static void main(String[] args) {
		f7();
	}
	private static void f7() {
		//RemoteController a = new Television();
		RemoteController a = new Audio();
		a.method1();
	}
	private static void f3() {
		action(new Television());
		action(new Audio());
	}
	private static void action(RemoteController remote) {
		//사용할 변수, 메서드는 타입을 따른다.
		System.out.println(remote.CHANNER); //상수접근
		
		//상수
		remote.turnOff();
		remote.turnOn();
		remote.method1();
		remote.method2();
		
		//default
		remote.method3();
		
		//

	}
	private static void f2() {
		Audio audio = new Audio();
		audio.method1();
		audio.method2();
		audio.method3();
		audio.turnOn();
		audio.turnOff();
		audio.show();
		RemoteController.CHANNER();
	}
	
	private static void f1() {
		Television t1 = new Television() ;
		t1.method1();
		t1.method2();
		t1.method3();
		t1.method4();
//		RemoteController.method4();
		
		System.out.println(t1.CHANNER);
		System.out.println(RemoteController.CHANNER);
		System.out.println(RemoteController.CHANNER);
	}
}
