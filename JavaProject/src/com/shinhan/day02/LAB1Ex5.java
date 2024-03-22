package com.shinhan.day02;

import java.util.Scanner;

public class LAB1Ex5 {

	public static void main(String[] args) {
		draw();
	}

	private static void draw() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("직각 역삼각형을 출력할 줄 수 : ");
		int input = sc.nextInt();
		
		for(int i = 0; i < input; i++) {
			for(int j = input-i; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}

}
