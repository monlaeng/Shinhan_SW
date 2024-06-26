package com.shinhan.day10.thread;

public class MultiThreadTest2 {

	public static void main(String[] args) {
		//공유데이터
		BathRoom room = new BathRoom();
		//흐름 3개 만듦
		BathRoomThread t1 = new BathRoomThread(room, "김");
		BathRoomThread t2 = new BathRoomThread(room, "박");
		BathRoomThread t3 = new BathRoomThread(room, "양");
		
		t1.start();
		t2.start();
		t3.start();
	}
	
	
	public static void f2(String[] args) {
		
		ShareArea shareArea = new ShareArea(
				new Account("112", "이몽룡", 2000),
				new Account("113", "성춘향", 1000)
		);
		Thread t1 = new TransferThread(shareArea);
		Thread t2 = new Thread(new PrintThread(shareArea));
		t1.start();
		t2.start();
	}

	public static void f1(String[] args) {
		System.out.println(Thread.currentThread().getName() + "시작");

		Thread t1 = new UppercaseThread2();
		Thread t2 = new Thread(new UppercaseThread());
		Thread t3 = new UppercaseThread2();
		t1.start();
		t2.start();
		t3.start();

		System.out.println(Thread.currentThread().getName() + "끝");
	}
}
