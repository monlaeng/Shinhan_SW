package com.shinhan.day05;

public class PlayBird {

	public static void main(String[] args) {
		Duck du1 = new Duck("꽥꽥이", 2, 15);
		Duck du2 = new Duck("꽉꽉이", 2, 18);
		Sparrow sp1 = new Sparrow("쨱짹이", 2, 10);
		Sparrow sp2 = new Sparrow("뾰롱이", 2, 8);
		
		du1.fly();
		du1.sing();
		String ds = du1.toString();
		System.out.println(ds);
		
		du2.fly();
		du2.sing();
		String ds2 = du2.toString();
		System.out.println(ds);
		
		sp1.fly();
		sp1.sing();
		String ss = sp1.toString();
		System.out.println(ss);
		
		sp2.fly();
		sp2.sing();
		String ss2 = sp2.toString();
		System.out.println(ss2);
	}

}