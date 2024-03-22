package com.shinhan.day02;

import java.util.Scanner;

public class LAB2Ex2 {

	public static void main(String[] args) {
		method2();
		
		
		
	}

	private static void method2() {
		// TODO Auto-generated method stub
		
	}

	private static void method1() {
Scanner sc = new Scanner(System.in);
		
		System.out.print("2~100사이의 정수를 입력하세요. : ");
		int input = sc.nextInt();
		int cnt = 0;
		
		for(int i = 2; i < input; i++) {
			if(input % i == 0) {
				cnt++;
			}
		}
		if(cnt > 0) {
			System.out.printf("%d는(은) 소수가 아닙니다.", input);
		} else {
			System.out.printf("%d는 소수입니다.", input);
		}		
	}
	

}
