package com.shinhan.day09;

public class Service {
	
	@PrintAnnotation
	public void method1() {
		System.out.println("method1....");
	}
	@PrintAnnotation("*")
	public void method2() {
		System.out.println("method2....");
	}
	@PrintAnnotation(value = "#", number = 20)
	public void method3() {
		System.out.println("method3....");
	}
	@PrintAnnotation(value = "$", number = 30, subject = "web", subject2 = "framework")
	public void method4() {
		System.out.println("method3....");
	}
}
