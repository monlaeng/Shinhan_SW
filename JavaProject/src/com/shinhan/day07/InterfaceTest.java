package com.shinhan.day07;

interface AInterface{
	void method1();
}
interface BInterface extends AInterface{
	public abstract void method2();
}
class MyClass implements BInterface{
	public void method1() {
		
	};
	public void method2() {
		
	};
}

public class InterfaceTest {

	public static void main(String[] args) {
		MyClass a = new MyClass();
		a.method1();
		a.method2();
	}

}
