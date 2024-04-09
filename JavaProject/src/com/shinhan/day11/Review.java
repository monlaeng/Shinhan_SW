package com.shinhan.day11;

import com.shinhan.day10.thread.Account;

//제네릭: 구체적인 타입은 사용할 때 결정, 컴파일 시에 강한 타입 체크, Object 사용한다면 강제형변환이 필요



class Box<T>{
	T content;

	
	
	public Box(T content) {
		this.content = content;
	}



	@Override
	public String toString() {
		return "Box [content=" + content + "]";
	}



	public T getContent() {
		return content;
	}



	public void setContent(T content) {
		this.content = content;
	}

	
	
}

class BigBox <T, E> extends Box<T> {
	E size;

	public BigBox(T content, E size) {
		super(content);
		this.size = size;
	}

	@Override
	public String toString() {
		return "BigBox [size=" + size + "]";
	}
	
	
}

class AccountChild extends Account {

	
}


public class Review {
	public static void main(String[] args) {
		f5();
	}
	
	private static void f5() {
		//배열은 실행 시 만들어진다.
		String[] arr = {"A", "B", "C"};
		Object[] arr2;
		arr2 = arr;
		arr2[0] = 10;

		//제네릭은 배열생성불가
		//Box<Account> [] b3 = new Box<Account>[10];
	}

	private static void f4() {

		Box<Account> b1 = call3(new Account("110", "A", 100));
		Box<AccountChild> b2 = call3(new AccountChild());
		Box<Account> b3 = call3(new Account("112", "C", 300));
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
 		}
	
	
	
	private static <T extends Account> Box<T> call3(T data) {
		return new Box<T>(data);
	}

	
	private static void f3() {
		Box<Double> b1 = call2(3.14);
		Box<Integer> b2 = call2(100);
		Box<Long> b3 = call2(1234567890000000L);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
 		}
	
	private static <T extends Number> Box<T> call2(T data) {
		return new Box<T>(data);
	}

	private static void f2() {
		Box<String> b1 = call("문자");
		Box<Integer> b2 = call(100);
		Box<Account> b3 = call(new Account("112", "A", 100));
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
 		}

	private static <T> Box<T> call(T data) {
		return new Box<T>(data);
	}

	private static void f1() {
		Box<String> b1 = new Box<String>("문자");
		Box<String> b2 = new Box<String>("문자");
		Box<Integer> b3 = new Box<Integer>(100);
		Box<Integer> b4 = new Box<Integer>(100);
//		Box<Integer> b4 = new Box<Integer>(12);
		b4.setContent(200);
		
//		Box<Account> b5 = new Box<>();
//		b5.setContent(new Account("113", "B", 100));
		
		Box<Account> b6 = new Box<>(new Account("113", "B", 200));
		
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);
//		System.out.println(b5);
		System.out.println(b6);
	}

	
	
	
	
	
//	private static void f2() {
//		Box<String> box1 = call("문자");
//		Box<Integer> box2 = call(100);
//		Box<Account> box3 = call(new Account("112", "j", 100));
//		
//		System.out.println(box1);
//		System.out.println(box2);
//		System.out.println(box3);
//	}
//
//	private static <T> Box<T> call(T t) {
//		
//		return new Box<T>(t);
//	}
//
//	private static void f1() {
//		Box<String> box1 = new Box<>();
//		Box<String> box2 = new Box<>();
//		Box<Integer> box3 = new Box<>();
//		Box<Account> box4 = new Box<>();
//		
//		box1.content="String";
//		box2.content="String";
//		box3.content=100;
//		Integer a = box3.content;
//		Account acc = box4.content;
//		
//		new Account(null, null, 0).deposit(1000);
//		
//		System.out.println(a);
//		System.out.println(acc);
//	}
}
