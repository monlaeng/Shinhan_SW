package com.shinhan.day11;

public class PrintThread extends Thread{

		boolean stop;	//default는 false
		
		void setStop(boolean stop) {
			this.stop = stop;
		}
		
		//2.interrupt()메서드로 Exception 발생 시키기
		public void run() {
			try {
				while(true) {
					System.out.println("실행중.....");
					sleep(1);
				}
			} catch(InterruptedException e) {
				//e.printStackTrace();
			}
			System.out.println("리소스정리");
			System.out.println("정상적으로 쓰레드 종료");
		}
		
		//1.조건문 이용하여 안전하게 쓰레드 종료하기.
		public void run2() {
			while(!stop) {
				System.out.println("실행중.....");
			}
			System.out.println("리소스정리");
			System.out.println("정상적으로 쓰레드 종료");
		}
		
}
