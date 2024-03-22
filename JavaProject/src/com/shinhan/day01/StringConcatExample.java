package com.shinhan.day01;

public class StringConcatExample {
	public static void main(String[] args) {
		f4();
	}
	
	private static void f4() {
		int a = 100;
		{
			int b = 200;
			System.out.println("1." + (a+b));
		}
		if(a>=100) {
			int b = 300;
			System.out.println("2." + (a+b));
		}
		
		System.out.println("3." + a);
		//System.out.println(a+b);	//오류
	}

	private static void f3() {
		int a = 100;
		String s = String.valueOf(a);
		String s2 = a+"";
		System.out.println(s);
		System.out.println(s2);
	}

	public static void f1(String[] args) {
		//숫자 연산
		int result1 = 10 + 2 + 8;
		System.out.println("result1: " + result1);

		//결합 연산
		String result2 = 10 + 2 + "8";
		System.out.println("result2: " + result2);

		String result3 = 10 + "2" + 8;
		System.out.println("result3: " + result3);

		String result4 = "10" + 2 + 8;
		System.out.println("result4: " + result4);

		String result5 = "10" + (2 + 8);
		System.out.println("result5: " + result5);
	}
}