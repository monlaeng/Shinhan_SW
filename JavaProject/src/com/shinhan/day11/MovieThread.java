package com.shinhan.day11;

public class MovieThread extends Thread {
	@Override
	public void run() {
		try {
			while (true) {
				System.out.println("동영상을 재생합니다.");
				sleep(1);
			}
		} catch (InterruptedException e) {

		}
		System.out.println("자원종료");
		System.out.println("안전종료");
	}
}
