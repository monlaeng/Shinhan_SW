package com.shinhan.day09;

import java.io.FileNotFoundException;
import java.io.IOException;


//정의는 있고 구현은 없다.

interface MyInterface{
	public abstract void method1();
	void method2() throws IOException;
	void method3() throws Exception;
}
//구현 class
//1. 부모의 Exception이 존재하지 않은 경우 : 없거나 RuntimeException 가능
//2. 자식은 부모의 Exception보다 하위이어야한다.
class MyClassImpl implements MyInterface{

	@Override
	public void method1() throws RuntimeException {
		System.out.println("method1");
	}

	@Override
	public void method2() throws FileNotFoundException {
		System.out.println("method2");
	
	}
	@Override
	public void method3() throws Exception {
		System.out.println("method3");
		
	}
	
}

public class Review {
	//1. field
	MyInterface a = new MyClassImpl();
	//익명구현 class
	public static void main(String[] args) {
		//2.local 변수
		MyInterface b = new MyClassImpl();
		MyInterface b2 = new MyInterface() {
			public void method1() {
			}

			@Override
			public void method2() throws IOException {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void method3() throws Exception {
				// TODO Auto-generated method stub
				
			}
		};
		call(new MyClassImpl());
		call(new MyClassImpl());
	}
	private static void call(MyInterface c) {
		
	}
	
}
