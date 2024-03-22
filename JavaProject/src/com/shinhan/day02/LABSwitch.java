package com.shinhan.day02;

import java.util.Scanner;

public class LABSwitch {

	public static void main(String[] args) {
		printSeason2();
	}

	private static void printSeason2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("태어난 달을 입력: ");
		int month = sc.nextInt();
		String season;
		
		if(month==3|| month==4 || month==5) {
			season = "봄";
		} else if(month==6 || month==7 || month==8) {
			season = "여름";
		} else if(month==9 || month==10 || month==11 ) {
			season = "가을";
		} else if(month==12 || month==1 || month==2) {
			season = "겨울";
		} else {
			System.out.println("1~12 사이으 숫자만 입력하셔야 합니다.");
			sc.close();
			return;
		}
		System.out.printf("%s에 태어나셨군요.", season);
		sc.close();
	} 

	private static void printSeason() {
		Scanner sc = new Scanner(System.in);
		System.out.print("태어난 달을 입력: ");
		int month = sc.nextInt();
		String season;
		switch(month) {
		case 3, 4, 5 -> {
			season = "봄";
		}
		case 6, 7, 8 -> {
			season = "여름";
		}
		case 9, 10, 11 -> {
			season = "가을";
		}
		case 12, 1, 2 -> {
			season = "겨울";
		}
		default -> {
			System.out.println("1~12 사이의 숫자만 입력하셔야 합니다.");
			sc.close();
			return;	//함수를 빠지기, break는 switch 빠지기.
		}
		}
		System.out.printf("%s에 태어나셨네요.", season);
	}

}
