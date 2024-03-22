package com.shinhan.day02;

import java.util.Scanner;

public class LAB2Ex8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		sc.close();
		
		gcd(num1, num2);
	}

	private static void gcd(int num1, int num2) {
		//int min = num1>num2 ? num2 :num1;
		int min = Math.min(num1, num2);
		int result = 1;
		
		for(int i=min; i > 1; i--) {
			if(num1 % i == 0) {
				if(num2 % i == 0) {
					result = i;
					break;
				}
			}
		}
		
		System.out.println(result);
		
		
	}

}
