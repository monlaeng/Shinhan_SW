package com.shinhan.day11;

//Process : 실행중인 하나의 프로그램
//Thread : 프로그램에서 하나의 흐름
//Multi Thread : 실행중인 하나의 프로그램의 흐름이 여러 개
//1)Thread class 상속
//2)Runnable interface 구현

class MyThread1 extends Thread {
	MyThread1(String name) {
		super(name);
	}
	@Override
	public void run() {
		System.out.println(currentThread().getName());
	}
	
}

class MyThread2 extends Object implements Runnable {
	String name;
	MyThread2(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() +  ": " + name);
	}
	
}

public class Review2 {
	public static void main(String[] args) {
		f1();
	}

	private static void f1() {
		MyThread1 t1 = new MyThread1("신한 1");
		Thread t2 = new MyThread1("신한 2");
		Thread t3 = new Thread("신한 3") {
			
			@Override
			public void run() {
				System.out.println(currentThread().getName());
			}
		};
		MyThread2 myrunnable = new MyThread2("신한 4");	//thread가 아니고 runaable 구현 class
		Thread t4 = new Thread(myrunnable);	//이제 thread가 됨.
		Thread t5 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Runnable의 익명구현class");
			}
		});
		Thread t6 = new Thread(() -> {			//람다 표현식으로 구현
				System.out.println("Runnable의 익명구현class(람다식)");
			});
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		System.out.println(Thread.currentThread().getName() + " thread End");
	}
}
