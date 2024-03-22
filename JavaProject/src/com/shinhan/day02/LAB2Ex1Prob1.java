package com.shinhan.day02;

import java.util.Scanner;

public class LAB2Ex1Prob1 {

	public static void main(String[] args) {
		method5();
	}

	private static void method5() {
		aa:for(int i = 1; i < 10; i++) {
			//if(i==5) continue;
			for(int j = 2; j < 10; j++) {
				if(j==4) continue aa ;	//원하는 label의 loop 부분 패스
				System.out.printf("%2d * %2d = %2d  ", j, i, i*j);
			}
			System.out.println();
		}
		
	}

	private static void method4() {
		for(int i = 1; i < 10; i++) {
			//if(i==5) continue;
			for(int j = 2; j < 10; j++) {
				if(j==4) continue ;	//밑의 loop을 패스
				System.out.printf("%2d * %2d = %2d  ", j, i, i*j);
			}
			System.out.println();
		}			
	}

	private static void method3() {
		aa:for(int i = 1; i < 10; i++) {
			for(int j = 2; j < 10; j++) {
				//if(j==5) break;	//가장 가까운 for 빠지기
				if(j==5) break aa;	//원하는 for 빠지기 (label 부여하고 이름을 사용)
				System.out.printf("%2d * %2d = %2d  ", j, i, i*j);
			}
			System.out.println();
		}		
	}

	private static void method2() {
		for(int i = 2; i < 10; i++) {
			for(int j = 1; j < 10; j++) {
				System.out.printf("%2d * %2d = %2d  ", i, j, i*j);
			}
			System.out.println();
		}
		
	}

	private static void method1() {
		Scanner sc = new Scanner(System.in);

		System.out.print("1보다 크고 10보다 작은 정수를 입력하세요. : ");
		int input = sc.nextInt();

		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d\n", input, i, input * i);
		}
		sc.close();

	}

}
