package com.shinhan.day03;

import java.util.Scanner;

public class Chapter5Check {

	public static void main(String[] args) {
		Ex9();
	}

	private static void Ex9() {
		Scanner sc = new Scanner(System.in);
		Boolean isEnd = false;
		int student = 0;
		int[] scores = null;
		while(!isEnd) {
			menu();
			int choice = sc.nextInt();
			switch(choice) {
			case 1 -> {
				System.out.print("학생수> ");
				student = sc.nextInt();
				scores = new int[student];
			}
			case 2 -> {
				for(int i = 0; i < student; i++) {
					System.out.printf("scores[%d]>", i);
					scores[i] = sc.nextInt();
				}
			}
			case 3 -> {
				for(int i = 0; i < student; i++) {
					System.out.printf("scores[%d] : %d\n", i, scores[i]);
				}
			}
			case 4 -> {
				int max = scores[0];
				double sum = 0;
				for(int data: scores) {
					sum += data;
					if(data > max) {
						max = data;
					}
				}
				System.out.printf("최고 점수: %d\n", max);
				System.out.printf("평균 점수: %.1f\n", sum/student);
			}
			case 5 -> {
				isEnd = true;
			}
			}
		}
		System.out.println("프로그램 종료");
	}

	private static void menu() {
		System.out.println("------------------------------------------------");
		System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
		System.out.println("------------------------------------------------");
		System.out.print("선택> ");
	}

	private static void Ex8() {
		int[][] array = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88}
		};
		int cnt = 0, sum = 0;
		
		for(int datas[]:array) {
			for(int data : datas) {
				cnt++;
				sum += data;
			}
		}

		System.out.println("합 : " + sum );
		System.out.println("평균 : " + sum/cnt );
	}

	private static void Ex7() {
		int[] array = {1, 5, 3, 8, 2};
		int max = Integer.MIN_VALUE;
		
		for(int data:array) {
			if(data > max) {
				max = data;
			}
		}
		System.out.println(max);
	}

}
