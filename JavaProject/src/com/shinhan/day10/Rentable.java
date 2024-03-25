package com.shinhan.day10;

//타입파라메터는 영문자대문자 아무거나 <A>
public interface Rentable<P> {
	
	void method1();
	P rent();
	
}
