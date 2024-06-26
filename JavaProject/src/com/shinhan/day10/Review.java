package com.shinhan.day10;

//변수(data) + 기능(메서드)
//class Machine extends Object{
//	super();	//명시적으로 부모를 호출 하려면 항상 첫 줄에 사용해야 한다.
//	System.out.println("Machine 기본생성자");
//}
class Machine {

}

//규격서 : 상수 + 추상메서드 + default, static, private 메서드
interface MyInterface {
	public abstract void method1();
}

//상속(부모의 private 제외한 모든 변수(data) + 기능(메서드) 접근가능, 
//수정(override), 추가가능(이름 같고 매개변수가 다르다면 Overloading), 추가(이름다름)
class CoffeeMachine extends Machine implements MyInterface, AutoCloseable {

	public CoffeeMachine() {
		super();
		System.out.println("CoffeeMachine의 기본생성자");
	}

	@Override
	public void method1() {
		System.out.println("method1......구현class가 interface에서 정의한 추상메서드를 구현");
	}

	@Override
	public void close() throws Exception {
		System.out.println("AutoCloseable interface의 close() 재정의");
	}

	@Override
	public String toString() {
		return "CoffeeMachine [.......]....field가 있다면 이용해서 정보를 문자열로 만들기";
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return "Coffee".hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return "Coffee".equals("Coffee");
	}

}

public class Review {
	public static void main(String[] args) {
		
		try(CoffeeMachine coffee1 = new CoffeeMachine();
			CoffeeMachine coffee2 = new CoffeeMachine();)
		{
			coffee1.method1();
			coffee2.method1();
			System.out.println(coffee1);	//toString() 호출 
			System.out.println(coffee2);	//toString() 호출 
			System.out.println(coffee1 == coffee2);
			System.out.println(coffee1.equals(coffee2));
			//coffee1.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
