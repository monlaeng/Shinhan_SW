package com.shinhan.day03;

public class LAB1Ex2ArrayTest {
	public static void main(String[] args) {
		int[][] a = {{30, 30, 30, 30}, {40, 40, 40, 40}, {50, 50, 50, 50}};
		int[][] b = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		int[][] c = new int[a.length][a[0].length];
		sub(a, b, c);
		prn(c);
		//System.arraycopy(arr, 0, arr3, 0, arr.length);	//값을 복사
	}
	public static int[][] sub(int[][] a, int[][] b, int[][] c) {
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				c[i][j] = a[i][j] - b[i][j];
			}
		}
		
		System.arraycopy(c, 0, c, 0,c.length);

		
		return c;
	}
	public static void prn(int[][] c) {
		for(int[] data:c) {
			for(int data2:data) {
				System.out.print(data2 + " ");
			}
			System.out.println();
		}
	}
}
