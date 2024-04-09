package com.shinhan.day10.thread;

//공유영역

public class BathRoom {
	// synchronized : 하나의 thread가 이 메서드 수행 중 Lock 건다
	// 즉, 다른 Thread가 접근불가, 하나의 thread가 메서드 벗어나면 대기 thread가 들어온다.

	boolean isFirst = true;
	
	// 동기화 메서드
	//****wait() 와 notify()는 동기화 메소드 또는 블록에서만 호출 할 수 있다.
	synchronized void use(String name) {

		if(isFirst && name.equals("김")) {
			isFirst = false;
			try {
				wait();	//다른 Thread가 들어올 수 있다.
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(name + "입장");
		System.out.println(name + "사용중");
		System.out.println(name + "퇴장");
		System.out.println("-----------------");

		notifyAll(); //wait() 상태의 쓰레드를 실행대기상태로 만들어준다.
	}

	void use2(String name) {
		// 동기화 block
		synchronized (this) {
			System.out.println(name + "입장");
			System.out.println(name + "사용중");
			System.out.println(name + "퇴장");
			System.out.println("-----------------");
		}
	}

}
