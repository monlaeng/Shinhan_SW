package com.shinhan.day04;

public class CarTest {

	public static void main(String[] args) {
		method2();
	}

	private static void method2() {
		Car c1 = new Car("ABC모델", "black", 300);
		System.out.println(c1);
	}

	private static void method1() {
		Car c1 = new Car("ABC모델", "black", 300);
		String result = c1.CarInfoPrint("***");
		System.out.println(result);
		
		c1.powerOn();
	}

}
