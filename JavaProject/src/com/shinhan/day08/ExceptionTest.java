package com.shinhan.day08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class ExceptionTest {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		try {
			method7();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("~~~~~Main end~~~~~");
	}

	private static void method7() throws IOException, ClassNotFoundException {
		FileReader fi = new FileReader("src/com/shinhan/day08/Book22.java");
		int i;
		while ((i = fi.read()) != -1) {
			System.out.println((char) i);
		}
		fi.close();
		;
	}

	private static void method6() {
		try (FileReader fi = new FileReader("src/com/shinhan/day08/Book.java")) {
			int i;
			while ((i = fi.read()) != -1) {
				;

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void method5() {
		FileReader fi = null;
		int i;
		try {
			fi = new FileReader("src/com/shinhan/day08/Book.java");
			try {
				while ((i = fi.read()) != -1) {
					System.out.print((char) i); // 1013 .. returnEnterㅢ ASCII code 값
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			;
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않음 " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				fi.close(); // 자원 반납(파일 열기 수 닫기,DB 연결 후 해체
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				System.out.println("파일 open ,접근 금지.");
				e.printStackTrace();
			}
		}
	}

	private static void method4() {
		// 하나의 메서드에서, 혹은 class에서 같은 이름의 class를 이용하는 경우
		// 같은 패키지를 먼저 검색
		// 다른 패키지의 class는 반드시 패키지 이름까지 사용한다.
		Book a = new Book();
		com.shinhan.day09.Book b = new com.shinhan.day09.Book();
		System.out.println(a);
		System.out.println(b);

		try {
			Class mybook = Class.forName("com.shinhan.day09.Book");
			System.out.println(mybook.getName());
			System.out.println(mybook.getSimpleName());
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		System.out.println("**********************");

	}

	private static void method2(int i) {
		// 일반 Exception(RuntimeExcpion이 아닌 Exception) 컴파일 시에 check
		// 반드시 Excption처리를 해야한다
		// 1.내가 한다. 2)떠넘긴다. (나를 부른곳으로 떠넘긴다)
		InputStream input = System.in;
//		int data= input.read();
		try {
			int data = input.read();
			System.out.println((char) data);

		} catch (RuntimeException ex) {
			ex.printStackTrace();
		}
		System.out.println();
	}

	private static void method1(int count) {
		// 예외 : 1)RuntimeException...실행 시 오류발생 2)일반Exception
		int score = 100;
		int[] arr = new int[10];
		String s = "100";

		// if(count == 0) return;
		// 오류처리로직과 비즈니스로직 처리가 섞인다. 권장하지 않음

		// try-catce : 오류처리로직과 비지니스로직 처리를 섞을 수 있다.

		try {
			System.out.println("평균은 " + score / count);
			arr[9] = 99;
			System.out.println(arr[9]);
			System.out.println(Integer.parseInt(s) + 200);
		} catch (ArithmeticException ex) {
			// Exception 처리함...그러므로 프로그램 중단없이 계속 진행된다.
			System.out.println("연산오류....." + ex.getMessage());
		} catch (NullPointerException ex) {
			// Exception 처리함...그러므로 프로그램 중단없이 계속 진행된다.
			System.out.println("연산오류....." + ex.getMessage());
		} catch (ArrayIndexOutOfBoundsException ex) {
			// Exception 처리함...그러므로 프로그램 중단없이 계속 진행된다.
			System.out.println("연산오류....." + ex.getMessage());
		} catch (NumberFormatException ex) {
			// Exception 처리함...그러므로 프로그램 중단없이 계속 진행된다.
			System.out.println("연산오류....." + ex.getMessage());
		} finally {
			System.out.println("오류가 있거나 없거나 무조건 수행하는 업무이다.");
		}
		System.out.println("-----------------------------------------");
	}
}
