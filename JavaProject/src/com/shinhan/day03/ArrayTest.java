package com.shinhan.day03;

import java.util.Arrays;

//>java ArrayTest
//JVM이 class load(byte code가 method 영역으로 들어간다.)
//검증
//main 시작

public class ArrayTest {
	//명령행 매개변수(argument) new String[2]
	//2개 입력받아서 5칙연산 수행하기
	public static void main(String[] args) {
		
		if(args.length==2) {
			int su1 = Integer.parseInt(args[0]);
			int su2 = Integer.parseInt(args[1]);
			System.out.println(su1+su2);
			System.out.println(su1-su2);
			System.out.println(su1*su2);
			System.out.println(su1/su2);
			System.out.println(su1%su2);
		}
		System.out.println("-----------------------");

		
	}

	private static void method2() {
		int[] arr = new int[] {10, 20, 30};
		String[] arr2 = {"자바", "디비", "웹" };
		System.out.println("====일반for====");
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("====향상for, 확장for====");
		for(int data:arr) {
			System.out.println(data);
		}
		for(String data:arr2) {
			System.out.println(data);
		}

	}

	private static void method1() {
		int[] arr = new int[] {10, 20, 30};
		int[] arr2 = arr;	//주소의 복사
		int[] arr3 = new int[arr.length];
		
		System.arraycopy(arr, 0, arr3, 0, arr.length);	//값을 복사
		
		arr[0] = 99;
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));
		
	}

	private static void call9() {
		String[][] arr = new String[3][];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new String[] {"자바"+i, "DB"+i};
			for(int j = 0; j < arr[i].length; j++) {
				System.out.println(arr[i][j]);
			}
		}
	}

	private static void call8() {
		//배열선언+생성+초기화
		String[] arr = new String[] {"자바", "DB", "WEB", "Framework"};
		String[] arr2 = new String[4];	//null로 초기화된다.
		arr2[0] = "자바";
		arr2[1] = "DB";
		arr2[2] = "WEB";
		arr2[3] = "Framework";
		arr[0] += "";
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "---");
			System.out.print(arr2[i] + "---");
			System.out.print(arr[i]==arr2[i]?"주소같다":"주소다르다");
			System.out.print(arr[i].equals(arr2[i])?"---값이같다":"---값이다르다");
			System.out.println();
		}
	}

	private static void call7() {
		int[][] score = new int[][] {{10, 20, 30, 40}, {1, 2, 3}};
		int total = 0;
		for(int i = 0; i < score.length; i++) {
			for(int j = 0; j < score[i].length; j++) {
				total += score[i][j];
				System.out.printf("[%d][%d] => %d ", i, j, score[i][j]);
			}
			System.out.println();
		}
		System.out.println(total);

	}

	private static void call6() {
		char[][] arr = {{'A','B','C'}, {'가','나'}, {'a', 'b', 'c', 'd'}};
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	private static void call5() {
		//2차원배열
		//1.배열선언
		int[][] arr;
		int[] arr2[];
		int arr3[][];
		//선언+생성+초기하
		int[][] arr4 = new int[][] {{9, 88},{77, 66, 55}};
		//2.배열생성
		arr = new int[3][4];
		arr2 = new int[3][];
		//배열생성+초기화
		arr3 = new int[][] {{10, 20, 30}, {40, 50}, {60, 70, 80},{90}};
		
		//3.배열사용
		System.out.println(arr.length);
		System.out.println(arr[0].length);
		System.out.println(arr4[0][1]);
		System.out.println(arr3[2][2]);
		
		
	}

	private static void call4() {
		// 1. 배열선언 
		// 2. 배열생성 + 3.초기화
		int[] arr;
		arr = new int[] {20, 40, 60};	//자동생성이 안됨
		System.out.println(arr.length);
		for (int index = 0; index < arr.length; index++) {
			System.out.println(index + "번째 " + arr[index]);
		}
	}

	private static void call3() {
		// 1. 배열선언 + 2. 배열생성 + 3.초기화
		int[] arr = new int[] {10, 20, 30, 40, 50};
		for (int index = 0; index < arr.length; index++) {
			System.out.println(index + "번째 " + arr[index]);
		}
	}

	private static void call2() {
		// 1. 배열선언 + 2. 배열생성
		int[] arr = new int[10];
		for (int index = 0; index < arr.length; index++) {
			System.out.println(index + "번째 " + arr[index]);
		}
	}

	private static void call() {
		// 변수 : 하나의 값을 저장하기 위한 기억장소 이름
		// 같은 타입의 값을 여러개를 저장하고자 한다. (하나의 이름으로 연속공간을 index로 참조한다.)
		// index는 0부터 시작한다.
		// 1. 배열서언
		int[] arr1;
		double arr2[];
		boolean arr3[];
		char[] arr4;
		String[] arr5;
		// 2. 배열생성...반드시 개수를 알아야한다. 개수를 써주면 자동으로 초기화된다.
		// 정수->0 ,실수->0.0, boolean->false, char->'',참조형->null
		arr1 = new int[10];
		arr2 = new double[10];
		arr3 = new boolean[10];
		arr4 = new char[10];
		arr5 = new String[10];
		// 3. 배열사용
		System.out.println(arr1[0]);
		System.out.println(arr2[0]);
		System.out.println(arr3[0]);
		System.out.println("*" + arr4[0] + "*");
		System.out.println(arr5[0]);

	}

}
