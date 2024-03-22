package com.shinhan.day05;

public class SIngleTonTest {

	public static void main(String[] args) {
		SingleTonClass a = SingleTonClass.getInstance();
		SingleTonClass b = SingleTonClass.getInstance();
		
		System.out.println(a==b);
		System.out.println(System.identityHashCode(a));
		System.out.println(System.identityHashCode(b));
	}

}