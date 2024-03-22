package com.shinhan.day07;

//외부class
class OuterClass {
	//1.instance 변수
	int a = 100;
	int score = 99;
	//2.class 변수
	static int b = 200;
	//3.instance method1
	void method1() {}
	//4.static method
	static void method2() {}
	
	//instance inner class
	class InnerClass {
		//1.instance 변수
		int a2 = 100;
		String score = "A학점";
		//2.class 변수
		static int b2 = 200;
		//3.instance method1
		void method3() {
			System.out.println("Inner class의 method3 : " + (a + b + a2 + b2));
			System.out.println("inner class의 field : " + score);
			System.out.println("outer class의 field : " + OuterClass.this.score);

		}
		
		//4.static method...instance 변수 사용불가
		static void method4() {
			System.out.println("Inner class의 static method4 : " + (b + b2));
		}
	}
	static class InnerClass2 {
		//1.instance 변수
		int a2 = 100;
		String score = "A학점";
		//2.class 변수
		static int b2 = 200;
		//3.instance method1
		void method3() {
			System.out.println("Inner class의 method3 : " + ( b + a2 + b2));
			System.out.println("inner class의 field : " + score);
			//불가 System.out.println("outer class의 field : " + OuterClass.this.score);

		}
		
		//4.static method...instance 변수 사용불가
		static void method4() {
			System.out.println("Inner class의 static method4 : " + (b + b2));
		}
	}
	
	void call() {
		//지역변수 : 내부 class에서 접근하면 무조건 변경불가(final)
		int price = 1000;
		//method 내에 있는 class, method 내에서만 접근가능
		class LocalClass{
			//1. field
			int price2 = 2000;
			static int price3 = 3000;
			//2. method
			void show() {
				System.out.println("LocalClass instance method");
				//price = 999;	내부에서 값을 바꿀 수 없다.
				System.out.println("지역변수를 local class에서 사용 price = " + price);
			}
			static void show2() {
				System.out.println("LocalClass class method");
			}
		}
		//price = 999;	값을 바꾸려면 내부에서 사용하지 않아야 바꿀 수 있다.
		System.out.println(price);
		
		//static
		System.out.println(LocalClass.price3);
		LocalClass.show2();
		//instance
		LocalClass local = new LocalClass();
		System.out.println(local.price2);
		local.show();
	}
	
}



public class InnerClassTest {
	
	public static void main(String[] args) {
		OuterClass outer = new OuterClass();
		outer.call();
	}
	
	public static void f2(String[] args) {
		
		System.out.println(OuterClass.InnerClass2.b2);
		OuterClass.InnerClass2.method4();
		
		OuterClass.InnerClass2 inner = new OuterClass.InnerClass2();
		System.out.println(inner.a2);
		System.out.println(inner.score);
		inner.method3();
	}
	
	public static void f1(String[] args) {
		
		
		//static 사용
		System.out.println(OuterClass.InnerClass.b2);
		OuterClass.InnerClass.method4();
		
		//instance 사용
		OuterClass out = new OuterClass();
		OuterClass.InnerClass inner = out.new InnerClass();
		OuterClass.InnerClass inner2 = new OuterClass().new InnerClass();
		System.out.println(inner.a2);
		System.out.println(inner.score);
		inner.method3();

	}
	
}
