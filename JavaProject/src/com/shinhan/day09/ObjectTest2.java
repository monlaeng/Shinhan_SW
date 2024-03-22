package com.shinhan.day09;

import java.util.Properties;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ObjectTest2 {
	public static void main(String[] args) {
		System.out.println("1.main시작");
		//f1(0);
		f8();
		System.out.println("4.main끝");
	}

	private static void f8() {
		//이메일
		String regExp = "(\\w+)@(\\w+\\.\\w)+";
		String data = "(wed0406)@daum.net";
		
		boolean result = Pattern.matches(regExp, data);
		System.out.println(result);
		
		Pattern patt = Pattern.compile(regExp);
		Matcher mat = patt.matcher(data);
		while(mat.find()) {
			System.out.println(mat.group());	//전체
			System.out.println(mat.group(0));	//전체
			System.out.println(mat.group(1));	//첫 번째
			System.out.println(mat.group(2));
		}
		
	}
	//\w : [0-9A-Za-z] 와 같은 의미
	//+ : 1개 이상
	//* : 0개 이상
	//[] : 선택
	//[-] : 범위
	//{3} : 횟수
	//\\d : [0-9] 같은 의미

	private static void f7() {
		//제어문자는 정해져있음 : \t \n \" ........ \\ -> \를 의미
		String regExp = "[01]{3}-[0-9]{3,4}-\\d{4}";	//전화번호
		String data = "010-1234-5678";
		boolean result = Pattern.matches(regExp, data);
		System.out.println(result);
		
		String data2 = "짜장면집 111-124-5678 "
				+ "스시집 010-7893-3424 "
				+ "aaaaaaa 012-7777-8888 "
				+ "nnnnnnnnnnn 010-895-7895";
		Pattern patt = Pattern.compile(regExp);
		Matcher mat = patt.matcher(data2);
		while(mat.find()) {
			System.out.println(mat.group());
		}
	}

	private static void f6() {
		//split은 빈 값도 사용, StringTokenizer는 빈토큰은 무시
		String str = "컴퓨터 커피@지갑, 마이크";
		String[] arr =str.split("@|,| ");	//주어진 값으로 분리
		System.out.println("배열갯수: " + arr.length);
		for(String s : arr) {
			System.out.println(s);
		}
		System.out.println("---------------");
		
		StringTokenizer st = new StringTokenizer(str, "@|,| ");
		System.out.println("토큰개수 : "+ st.countTokens());
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

	private static void f5() {
		StringBuilder s1 = new StringBuilder("Bio;dlem이것이 자바다");
		StringBuilder s2 = new StringBuilder("이것이 자바다");
		System.out.println(System.identityHashCode(s1));
	
	}

	private static void f4() {
		String s1 = "이것이 자바다";
		String s2 = new String("이것이 자바다");
		byte[] arr = {65,66,67,97,98,99};	//ABCabc
		String s3 = new String(arr);
		
		char[] arr2 = {'가', '나', '다'};
		String s4 = new String(arr2);
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(System.identityHashCode(s4));
		s4 += "!!!";
		System.out.println(System.identityHashCode(s4));
	}

	private static void f3() {
		//Properties는 Map을 구현함 (Key, value)
		//Properties의 키는 Set 만들어짐
		//Set<Object>
		//key가 String이었음 -> Properties(키가 Object)
		//				   <-
		
		System.out.println(System.getProperty("java.version"));
		
		Properties ps = System.getProperties();
		for(Object key:ps.keySet()) {
			String value = System.getProperty((String)key);
			System.out.println(key + "-->" + value);
		}
		
	}

	private static void f2() {
		long startTime = System.nanoTime();
		int total = 0;
		for(int i = 1; i < 1000000000; i++) {
			total += i;
		}
		long endTime = System.nanoTime();
		System.out.println(endTime-startTime + "ns");
	}

	private static void f1(int j) {
		System.out.println("2.f1 시작");
		//if(j==0) return;	//함수를 빠지기
		//if(j==0) System.exit(0);	//일반적으로 0은 정상종료, -1은 오류를 의미
		
		try {
			int i = 10 / j;
		} catch(Exception e) {
			e.getMessage();
		}
		System.out.println("3.f1 끝");
	}
}
