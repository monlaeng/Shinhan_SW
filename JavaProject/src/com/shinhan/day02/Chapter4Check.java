package com.shinhan.day02;

import java.util.Scanner;

public class Chapter4Check {

	public static void main(String[] args) {
		ex8();
	}
	
	private static void ex8() {
		Scanner sc = new Scanner(System.in);
		int sum = 0, amount = 0;
		boolean isStop = false;
		while(!isStop) {
			menu();
			String choice = sc.nextLine();
			switch(choice) {
			case "1" -> {
				System.out.print("예금액> ");
				amount = sc.nextInt();
				sum += amount;
				sc.nextLine();
			}
			case "2" -> {
				System.out.print("출금액> ");
				amount = sc.nextInt();
				if(sum - amount < 0) {
					System.out.println("잔고 부족");
				} else {
					sum -= amount;
				}
				sc.nextLine();
			}
			case "3" -> {
				System.out.println("잔고> " + sum);
			}
			case "4" -> {
				System.out.println("---END---");
				isStop = true;	//flag를 이용하기
			}
			default -> {
				break;	//switch 빠지기
			}
			}
			
		}
		sc.close();
		System.out.println("------프로그램 종료------");
	}
	
	private static void ex7() {
		Scanner sc = new Scanner(System.in);
		int sum = 0, amount = 0;
		aa:while(true) {
			menu();
			String choice = sc.nextLine();
			switch(choice) {
			case "1" -> {
				System.out.print("예금액> ");
				amount = sc.nextInt();
				sum += amount;
				sc.nextLine();
			}
			case "2" -> {
				System.out.print("출금액> ");
				amount = sc.nextInt();
				if(sum - amount < 0) {
					System.out.println("잔고 부족");
				} else {
					sum -= amount;
				}
				sc.nextLine();
			}
			case "3" -> {
				System.out.println("잔고> " + sum);
			}
			case "4" -> {
				System.out.println("---END---");
				break aa;	//label 빠지기 (while 빠지기)
			}
			default -> {
				break;	//switch 빠지기
			}
			}
			
		}
		sc.close();
		System.out.println("------프로그램 종료------");
	}

	private static void menu() {
		System.out.println("------------------------------\n1.예금 | 2.출금 | 3.잔고 | 4.종료 \n------------------------------");
		System.out.print("선택> ");		
	}
	private static void ex6() {
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void ex5() {
		for(int i = 1; i <= 10; i++) {
			for(int j = 1; j < 10; j++) {
				if(4*i + 5*j == 60) {
					System.out.printf("(%d, %d) \n", i, j);
				}
			}
		}
	}

	private static void ex4() {
		while(true) {
			int num1 = (int)(Math.random()*6)+1;
			int num2 = (int)(Math.random()*6)+1;
			System.out.printf("(%d , %d) \n", num1, num2);
			if(num1+num2 == 5) {
				break;
			}
			
		}
	}

	private static void ex3() {
		int sum = 0;
		for(int i = 3; i <= 100; i++) {
			if(i % 3 == 0) {
				sum += i;
			}
		}
		System.out.println("3의 배수의 총합 : " + sum);
	}

}
