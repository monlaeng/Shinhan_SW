package com.shinhan.day01;

import java.util.Scanner;

public class Programming1_minus {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int[] ledger = {10000, -13000, -4000, -2000, 6500, -20000};
//		int[] ledger = {-34152, -40000, -50000};
		
		System.out.println(solution(m, ledger));
	}

	private static int solution(int m, int[] ledger) {
		int total = 0;
		
		for(int i = 0; i < ledger.length; i++) {
			if((total+ledger[i]) >= -m) {
				total += ledger[i];
			}
		}
		return(total);
		
	}
	
	

}
