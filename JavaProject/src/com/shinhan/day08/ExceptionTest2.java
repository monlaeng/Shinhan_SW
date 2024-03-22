package com.shinhan.day08;

public class ExceptionTest2 {
	
	public static void main(String[] args) {
		method2(50);
	}
	
	private static void method2(int score) {
		try {
			if(score <= 70) throw new ScoreException("70초과만 가능");
			double avg = score/3;
		}catch(ScoreException e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}

	public static void f(String[] args) throws Exception {
		method1(70);
		System.out.println("*************");
	}

	private static void method1(int score) throws Exception {

		/*//조건에 맞지않으면 강제로 예외를 발생시키고자 한다.
		try {
			if(score <= 70) throw new Exception("오류!!!!");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		*/
		if(score <= 70) throw new Exception("오류!!!!!");
		System.out.println("--------------------");
	}
}
