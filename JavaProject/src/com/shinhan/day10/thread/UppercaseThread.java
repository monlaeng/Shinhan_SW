package com.shinhan.day10.thread;


//MultiThread : 
//A. 1)Thread 상속 2) run()메서드 재정의 3)new 객체 생성 후 start()...run() 수행됨
//B. 이미 상속받은 부모가 있다면 자바는 멀티상속불가하므로 Runnable interface 구현
class Parent {
	
}


public class UppercaseThread extends Thread implements Runnable {

	@Override
	public void run() {
		//1.영문자 대문지 입력.
	for(char i = 'A'; i <= 'Z'; i++ ) {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "i=" + i);
		}
	}

}
