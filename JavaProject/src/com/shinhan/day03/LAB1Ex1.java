package com.shinhan.day03;

import java.util.Arrays;

public class LAB1Ex1 {

	public static void main(String[] args) {
		int[] arr = {3, 24, 1, 55, 17, 43, 5};
		for(int i = 0; i < arr.length; i++) {
			for(int j = i+1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		
	}
	
}
