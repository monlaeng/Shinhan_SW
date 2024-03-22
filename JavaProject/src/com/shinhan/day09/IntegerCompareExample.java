package com.shinhan.day09;

import java.util.Random;

public class IntegerCompareExample {

	public static void main(String[] args) {
		double d = Math.random();
		System.out.println(d);
		
		Random r = new Random();
		double d2 = r.nextDouble(10);
		int i = r.nextInt(45);
		System.out.println(d2);
		System.out.println(i);
	}
	
	public static void f(String[] args) {
		Integer obj1 = 100;
		Integer obj2 = 100;
		Integer obj3 = 300;
		Integer obj4 = 300;
		//값의 범위가 -128~127이면 ==은 값을 비교하고 그 외에는 번지를 비교하기 때문이다.

		System.out.println(obj1 == obj2);
		System.out.println(obj3 == obj4);
		System.out.println(obj1.equals(obj2));
		System.out.println(obj3.equals(obj4));
		
		//객체는 항상 equals로 비교하자!!
	}
}
