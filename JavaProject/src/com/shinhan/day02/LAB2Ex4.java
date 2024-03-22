package com.shinhan.day02;

import java.util.Scanner;

public class LAB2Ex4 {

	public static void main(String[] args) {
		method2();
	}

	private static void method2() {
Scanner sc = new Scanner(System.in);
		
		System.out.print("양의 정수를 입력하세요 : ");
		int input = sc.nextInt();
		int cnt = 0, sum = 0;
		
		for(int i = input; i<=1000; i+=input) {
				cnt++;
				sum += i;
		}
		System.out.printf("%d의 배수 개수 = %d \n",input, cnt);
		System.out.printf("%d의 배수 합 = %d \n",input, sum);
		sc.close();
		
	}

	private static void method1() {
		Scanner sc = new Scanner(System.in);

		System.out.print("양의 정수를 입력하세요 : ");
		int input = sc.nextInt();
		int cnt = 0, sum = 0;

		for (int i = input; i <= 1000; i++) {
			if (i % input == 0) {
				cnt++;
				sum += i;
			}
		}
		System.out.printf("7의 배수 개수 = %d \n", cnt);
		System.out.printf("7의 배수 합 = %d \n", sum);
		sc.close();

	}

}
