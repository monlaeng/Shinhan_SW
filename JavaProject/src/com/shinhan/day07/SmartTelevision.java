package com.shinhan.day07;

public class SmartTelevision implements RemoteController,Searchable {
	public static void main(String[] args) {
		f6();
	}
	private static void f6() {
		//String, Integer class는 Comparable interface 구현하였다.
		//Comparable interface : 추상메서드 public abstract compartTo();
		//String class가 Compareable interface 구현...compareTo() 재정의
		String s1 = "A";
		String s2 = "C";
		Integer i1 = 100;
		Integer i2 = 105;
		
		int result = s1.compareTo(s2);	//문자 사이의 차이
		System.out.println(result);
		
		result = i1.compareTo(i2);		//-1, 0, 1
		System.out.println(result);
	}
	public void search(String url) {
		System.out.println("SmartTelevision search..");
	}
	public void method1(String url) {
		System.out.println("SmartTelevision method1..");
	}
	public void method2(String url) {
		System.out.println("SmartTelevision method2..");
	}
	public void turnOn(String url) {
		System.out.println("SmartTelevision turnOn..");
	}
	public void turnOff(String url) {
		System.out.println("SmartTelevision turnOff..");
	}

}
