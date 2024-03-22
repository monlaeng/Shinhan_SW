package com.shinhan.day05;

//java.lang 아래에 이쓴 class는 import 없이 사용가능
//그 외는 반드시 import 한다.
//다른 패키지에 있는 class를 이용하는 경우 반드시 import하고 사용한다.
public class BookTest {

	public static void main(String[] args) {
		method3();
	}

	private static void method3() {
		int a = Integer.MAX_VALUE;
		
		System.out.println(a);
		
		int b = Integer.compare(10, 30);
		System.out.println(b);
		
		int score = 10, score2 = 20;
		int c = Integer.max(score, score);
		System.out.println(c);
		System.out.println(score > score ? score : score2);
	}

	private static void method2() {
		//상수는 변경불가
		//Book.ISBN = "88888";
		
		System.out.println(Book.ISBN);
		System.out.println(Book.ISBN2);
		
		Book b1 = new Book();
		//올바른 사용은 아니다.
		System.out.println(b1.ISBN);
		System.out.println(b1.ISBN2);
	}

	private static void method1() {
		System.out.println(Book.bookCount);
		
		Book b1 = new Book() ;
		System.out.println(b1.title);
		System.out.println(b1.price);
		System.out.println(b1.publish);
		System.out.println(b1.publish2);
		System.out.println(b1.publish3);
	}

}
