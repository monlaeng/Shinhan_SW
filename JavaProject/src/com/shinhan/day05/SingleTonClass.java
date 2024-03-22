package com.shinhan.day05;

//SingleTone : 객체가 1번만 생성된다.
public class SingleTonClass {
	private static SingleTonClass single;
	private SingleTonClass() {
		
	}
	
	public static SingleTonClass getInstance() {
		if(single == null) {
			single = new SingleTonClass();
		}
		return single;
	}
}
