package com.shinhan.day04;

import java.util.Arrays;

public class Review {

	public static void main(String[] args) {
		method5();
	}
	private static void method5() {
		boolean[] arr = new boolean[3];
		System.out.println(Arrays.toString(arr));

	}
	private static void method4() {		//챕터5 문제 2번,3,4번
		int a = 0;
		Integer b=null;
		System.out.println(a);
		System.out.println(b);
		//String은 고정문자열
		String s = "자바";		//동일한 리터럴을 쓰면 같은 주소를 사용
		String s2 = "자바";
		String s3 = new String("자바");
		s = s + "프로그램";	//StringBuffer .append -> String
		
		//4번
		//2번이 틀림. new int[] 생략 불가능한 경우이다.
	}
	private static void method2() {
		// TODO Auto-generated method stub
		
	}
	private static void method3() {
		int[][] arr = new int[3][4];
		int[][] arr2 = new int[3][];
		int[] arr3[] = new int[3][];
		int arr4[][] = new int[3][];
		
		for(int i = 0; i < arr4.length; i++) {
			//System.out.println(arr4[i]);
			arr4[i] = new int[i+2];	//i가 0일 때 2, i-1일 때 3
			for(int j = 0; j < arr4[i].length; j++) {
				System.out.print(arr4[i][j] + " ");
			}
			System.out.println();
		}
	}

}
