package com.shinhan.day09;

import java.util.HashSet;

public class ObjectTest {
	
	public static void main(String[] args) {
		f3();
	}

	private static void f3() {
		ComputerVO3 com1 = new ComputerVO3("A", 100, "Samasung");
		ComputerVO3 com2 = new ComputerVO3("A", 100, "Samasung");
		ComputerVO com3 = new ComputerVO(null, 100, "Samsung");
		ComputerVO2 aa = new ComputerVO2("B", 1000, "CC");
		System.out.println(aa.model());

		System.out.println(com1);
		System.out.println(com2);
		System.out.println(com1.equals(com2));
		System.out.println(com1.getModel());
	}

	private static void f2() {
		ComputerVO2 com1 = new ComputerVO2("A", 100, "Samasung");
		ComputerVO2 com2 = new ComputerVO2("A", 100, "Samasung");
		System.out.println(com1);
		System.out.println(com2);
		System.out.println(com1.equals(com2));
	}

	private static void f1 () {
		ComputerVO com1 = new ComputerVO("A", 100, "Samsung");
		ComputerVO com2 = new ComputerVO("B", 200, "Samsung");
		System.out.println(com1);	//toString() 호출된다. 주소 return, 재정의가능
		System.out.println(com2);
		
		System.out.println(com1 == com2);	//주소비교, c++은 재정의 가능, 자바는 불가능
		System.out.println(com1.equals(com2));	//equals : 주소 비교, 재정의 가능
		
		//동일 객체 비교 (Hashcode(), equals() 재정의)
		//Set : 순서업소 중복불가
		HashSet<ComputerVO> computers = new HashSet();
		computers.add(com1);
		computers.add(com2);
		computers.add(new ComputerVO("A", 100, "Samsung"));
		System.out.println(computers.size());
		
		
	}
}
