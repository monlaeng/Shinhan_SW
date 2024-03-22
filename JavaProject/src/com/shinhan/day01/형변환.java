package com.shinhan.day01;

public class 형변환 {
	
	//byte < short < int < long < float < double
	//		 char
	public static void main(String[] args) {
		f2();
	}

	private static void f2() {
		long var1;
		int var2 = 100;
		
		//자동형변환
		var1 = var2;
		System.out.println("var1 = " + var1);
		
		//4byte 방에 8byte 값을 넣을 수 없기 때문에 오류
		//강제 형변환
		var1 = 2147483648L;	//data 손실 가능성 있다.
		var2 = (int)var1;
		System.out.println("var2 = " + var2);
	
		String str = "100";
		//int i = (int)str;
		//기본형은 casting 하여 형변환한다.
		//객체는 기능(함수, 메서드)으로 형변환한다.
		
		int i = Integer.parseInt(str);
		System.out.println(i);
	}

	private static void f1() {
		System.out.println("형변환에 대하여~~~");
		//**자동 형변환이 된다.
		//큰 방 = 작은 값
		byte var2 = 65;
		int var1 = var2;
		double var3 = var1;
		System.out.println(var3);
		
		//기본 리터럴이 int 이기에 var2의 값은 int이다.
		char ch = (char) var2;	//var2를 읽는다. 강제 형변환
		System.out.println(ch);
		
		char ch2 = 'a';
		int i = ch2;
		System.out.println("i=" + i);
		
	}
}
