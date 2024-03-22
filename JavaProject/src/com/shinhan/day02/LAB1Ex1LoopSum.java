package com.shinhan.day02;

import java.util.Scanner;

public class LAB1Ex1LoopSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("초기값을 정수로 입력하세요.: ");
		int base = sc.nextInt();
		System.out.print("마지막 값을 정수로 입력하세요.: ");
		int last = sc.nextInt();
		System.out.print("증가분을 정수로 입력하세요.: ");
		int inc = sc.nextInt();
		
		sc.close();
		
		int total = 0;
		for(int i = base; i <= last; i+=inc) {
			total += i;
		}
		if(total > 1000) {
			total += 2000;
		}
		System.out.printf("총합은 %d 입니다.", total);
	}

}
