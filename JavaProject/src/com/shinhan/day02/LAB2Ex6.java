package com.shinhan.day02;

import java.util.Scanner;

public class LAB2Ex6 {

	public static void main(String[] args) {
		method1();
	}

	private static void method1() {
		Scanner sc = new Scanner(System.in);

		int year = sc.nextInt();
		int day;
		if (year % 4 == 0) {
			if ((year % 400 == 0) || (year % 100 != 0)) {
				day = 29;
			} else {
				day = 28;
			}
		} else {
			day = 28;
		}
		System.out.printf("%d년 2월의 말일은 %d일 입니다.", year, day);
	}

}
