package com.shinhan.day09.generic;

import java.util.ArrayList;

public class GenericTest {
	public static void main(String[] args) {
		f2();
	}

	private static void f2() {
		//List : 순서있고 중복가능
		ArrayList<String> alist = new ArrayList<>();
		alist.add("월");
		alist.add("화");
		alist.add("토");
		alist.add("토");
		alist.add("토");
		for(String s:alist) {
			System.out.println(s);
		}
	}

	private static void f1() {
		
		Box<String, Integer> box1 = new Box<String, Integer> ("컴퓨터1", 100);
		System.out.println(box1);
		
		Box<Integer, String> box2 = new Box(123, "Large");
		System.out.println(box2);
		
	}
}
