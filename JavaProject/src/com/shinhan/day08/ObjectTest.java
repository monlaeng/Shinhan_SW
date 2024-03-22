package com.shinhan.day08;

import java.util.HashSet;

public class ObjectTest {
	public static void main(String[] args) {
		f8();
	}
	
	private static void f8() {
		
		Book book = new Book("A" , 1, "a");
		//b.equals(null); ... error
		book.equals("aa");
		
		//제네릭스 : type을 제한한다.
		HashSet<Book> datas = new HashSet<Book>();
		datas.add(new Book("A", 1000, "김"));
		datas.add(new Book("A", 1000, "김"));
		datas.add(new Book("A", 1000, "김"));
		datas.add(new Book("A", 2000, "김"));
		datas.add(new Book("B", 2000, "신"));

	
		System.out.println(datas.size());	//중복 불가능이므로 3개로 나옴.
		for(Book b:datas) {
			System.out.println(b);
		}
		
	}
	
	private static void f7() {
		//제네릭스 : type을 제한한다.
		HashSet<String> datas = new HashSet<String>();
		datas.add("월요일");		
		datas.add("토요일");		
		datas.add("토요일");		
		datas.add("화요일");		
		System.out.println(datas.size());	//중복 불가능이므로 3개로 나옴.
		for(String s:datas) {
			System.out.println(s);
		}
		
	}

	private static void f6() {
		//HashSet : 순서가 없다, 중복이 안된다. Key로 사용된다.
		HashSet datas = new HashSet();
		datas.add(100);
		datas.add("자바");
		datas.add(new Book("자바다", 20000, "신"));
		
		for(Object obj:datas) {
			if(obj instanceof Integer) {
				
			}else if(obj instanceof String) {
				
			}else if(obj instanceof Book) {
				
			}
		}
		
	}

	private static void f5() {
		// Object는 상속받아 만든 Integer
		Book obj1 = new Book("자바다", 20000, "신");
		Book obj2 = new Book("자바다", 20000, "신");

		System.out.println(obj1 == obj2);// 주소비교
		System.out.println(obj1.equals(obj2)); // //주소비교를 내용비교로 override 되어있음

		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));
	}
	
	private static void f4() {
		// Object는 상속받아 만든 Integer
		Dice obj1 = new Dice(100);
		Dice obj2 = new Dice(100);

		System.out.println(obj1 == obj2);// 주소비교
		System.out.println(obj1.equals(obj2)); // //주소비교를 내용비교로 override 되어있음

		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));
	}

	private static void f3() {
		// Object는 상속받아 만든 Integer
		Object obj1 = new Integer(100);
		Object obj2 = new Integer(100);

		System.out.println(obj1 == obj2);// 주소비교
		System.out.println(obj1.equals(obj2)); // //주소비교를 내용비교로 override 되어있음

		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));
	}


	private static void f2() {
		// Object는 상속받아서 만든 String
		Object obj1 = new String("자바");
		Object obj2 = new String("자바");

		System.out.println(obj1 == obj2);// 주소비교
		System.out.println(obj1.equals(obj2)); // //주소비교를 내용비교로 override 되어있음

		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));
	}

	private static void f1() {
		// Object는 모든 Object의 부모 class
		Object obj1 = new Object();
		Object obj2 = new Object();

		System.out.println(obj1 == obj2);// 주소비교
		System.out.println(obj1.equals(obj2)); // obj에서는 equals도 주소비교

		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));
	}
}