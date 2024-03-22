package com.shinhan.day05;

public class CaculatorTest {

	public static void main(String[] args) {
		System.out.println(Calculator.company);
		System.out.println(Calculator.company2);
		System.out.println(Calculator.plus(1, 2));
//		System.out.println(Caculator.minus(1, 2));
		
		double result = new Calculator().minus(1, 2);
		System.out.println(result);
	}

}
