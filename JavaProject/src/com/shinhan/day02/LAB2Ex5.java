package com.shinhan.day02;

public class LAB2Ex5 {
	public static void main(String[] args) {
		int sum=0, num=1;
		
		for(int i = 0; i < 15; i++ ) {
			num += i;
			sum += num;
		}
		System.out.printf("15번째까지의 합 : %d",sum);
	}
}
