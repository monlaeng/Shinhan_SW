package com.shinhan.day02;

import java.util.Scanner;

public class LAB2Ex7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int result = numsDay(2023, 2);
		System.out.println("말일은 " + result);
	}

	private static int numsDay(int year, int month) {
		int day;
		
		switch(month) {
		case 2 -> {
			if (year % 4 == 0) {
				if ((year % 400 == 0) || (year % 100 != 0)) {
					day = 29;
				} else {
					day = 28;
				}
			} else {
				day = 28;
			}
		}
		case 4, 6, 9, 11 -> {
			day = 30;
		}
		default -> {
			day = 31;
		}
		}
		
		return day;
		
	}

}
