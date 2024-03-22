package com.shinhan.day02;

import java.util.Scanner;

public class LAB1Ex2ForTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열을 입력하세요. : ");
		String input = sc.nextLine().toUpperCase();
		
		for(int i=0; i<input.length();i++) {
			for(int j=0; j<= i; j++) {
				System.out.print(input.charAt(j));
			}
			System.out.println();
		}
		sc.close();
	}
}
