package com.shinhan.day10.thread;


//process : 실행중인 하나의 프로그램
//thread : 하나의 process 내의 프로그램의 흐름
//Thread Class이용하면 MultiThread 프로그램이 가능
public class MultiThreadTest {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + "main thread 시작............");
		
		//1) 구현 class로 만들기(extends Thread)
		//Thread t1 = new UppercaseThread();
		//3)Runnable interface를 구현한다. (implements Runnable)
		Thread t1 = new Thread(new UppercaseThread());
		//2) 익명 구현 class로 만들기
		Thread t2 = new Thread() {

			@Override
			public void run() {
				//2.영문자 소문자 출력
				for(char i = 'a'; i<= 'z'; i++) {
					System.out.println(Thread.currentThread() + "i=" + i) ;
				}
			}
			
		};
		//4)interface로 익명구현 class 만들기
		Thread t3 = new Thread(new Runnable() {			
			@Override
			public void run() {
				for(int i=1; i <= 26; i++) {
					try {
						Thread.sleep(20);		//천천히 나오도록
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("졸지말자~~~~~" + i);
				}
			}
		}); 
		//5)익명구현 class 만들기 -> 람다표현식
		Thread t4 = new Thread(() -> {			
				for(int i=1; i <= 26; i++) {
					System.out.println("열공~~~~~" + i);
				}
		}); 
		t1.start();		//실행흐름 만들고 run() 호출
		t2.start();		//실행흐름 만들고 run() 호출
		t3.start();
		t4.start();
		//3.숫자 1~26 출력
		for(int i = 1; i < 26; i++) {
			System.out.println(Thread.currentThread().getName() + "i=" + i);
		}
	
		System.out.println(Thread.currentThread().getName() + "thread 끝..................");
	}
}
