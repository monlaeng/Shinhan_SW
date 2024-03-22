package com.shinhan.day02;

import java.util.Scanner;

public class LAB1Ex3SumTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요.: ");
		int input = sc.nextInt();
		int sum = 0;
		
		if(input%2==0) {
			for(int i=0; i<=input; i+=2) {
				sum += i;
			}
		} else {
			for(int i=1; i<=input; i+=2) {
				sum += i;
			}
		}
		System.out.printf("결과 값 : %d", sum);
		sc.close();
	}

}
