package com.shinhan.day02;

import java.util.Scanner;

public class LAB2Ex3 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1보다 크고 10보다 작은 정수를 입력하세요: ");
		int input = sc.nextInt();
		int mul = 1;
		if(input < 2 || input > 9) {
			System.out.println("잘못된 숫자가 입력되었습니다.");
			return;
		} 
		
		for(int i = 1; i <= input; i++) {
			mul *= i;
			System.out.printf("%d ! = %d\n", i, mul);
		}
		sc.close();
	}
}
