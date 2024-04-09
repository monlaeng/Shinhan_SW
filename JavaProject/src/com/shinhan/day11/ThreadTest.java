package com.shinhan.day11;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.shinhan.day10.thread.BathRoom;
import com.shinhan.day10.thread.BathRoomThread;

public class ThreadTest {
	public static void main(String[] args) {
		f8();
		System.out.println("main End");
	}


	private static void f8() {
		Thread thread = new MovieThread();
		 thread.start();
		 
		 try { Thread.sleep(3000); } catch (InterruptedException e) {}
		 
		 thread.interrupt();		
	}

	private static void f7() {
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		for(int i = 1; i <= 100; i++) {
			int end = i;
			Future<Integer> result = service.submit(new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {
					int sum = 0;
					for(int j = 1; j <= end; j++) {
						sum += j;
					}
					System.out.println(Thread.currentThread().getName() 
							+ ":" + end  + "까지 ==>" + sum);
					return sum;
				}
			});
			try {
				Integer a = result.get();
				System.out.println("a = " + a);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Integer a = result.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		service.shutdown();
	}

	private static void f6() {
		String s = "JAVA";	//안 보이지만 지역변수이므로 final이다
		int score = 100;
		class LocalClass {
			void method1() {
				//s += "프로그램";		final변수 변경 불가
				//System.out.println(score);	밖에서 값을 변경했기에 사용 불가
				System.out.println(s);
			}
		}
		
		score = 200;
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(s);
			}
		};
	}

	private static void f5() {
		String [][] mails = new String[1000][3];
		for(String[]arr : mails){
			int i = 1;
			arr[0] = "admin@my.com";	//누가
			arr[1] = "member" + i + "@my.com";	//누구에게
			arr[2] = "신상품 입고되었습니다.";
			i++;
		}
		//MultiThread(5개)로 1000명의 이메일을 보내기
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		//내부 class에서 지역변수에 접근(지역변수는 무조건 final 이다.)
		for(int index = 1; index <= 1000; index++ ) {
			int seq = index;	//값을 복사
			service.execute(new Runnable() {
		
				@Override
				public void run() {
					String message =
							"쓰레드 이름 : " + Thread.currentThread().getName() 
							+ " \n from: " + mails[seq][0] 
							+ "\n To:" + mails[seq][1] 
							+ "\n 내용: " + mails[seq][2];
					System.out.println(message);
				}
			});
		}
	}

	private static void f4() {
		AutoSaveThread t1 = new AutoSaveThread();
		t1.setDaemon(true);
		t1.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
	}

	private static void f3() {
		PrintThread t1 = new PrintThread();
		t1.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//t1.setStop(true);
		//비추천 t1.stop();
		
		t1.interrupt();
		
		
	}
	private static void f2() {
		//여러 쓰레드가 공유하는 공유데이터
		Calculator calculator = new Calculator();
	}

	private static void f1() {
		WorkThread t1 = new WorkThread("WorkThread1");
		WorkThread t2 = new WorkThread("WorkThread2");
		t1.start();
		t2.start();
	}
	
	
	
	
}
