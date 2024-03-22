package com.shinhan.day08;

public class ExceptionTest3 {
	public static void main(String[] args) {

	public NotExistIDException() {}

	public NotExistIDException(String message) {
		   super(message);
		}
}

class WrongPasswordException extends Exception {
	public WrongPasswordException() {
	}

	public WrongPasswordException(String message) {
		super(message);
	}

	}}

	private static void f2(String id, String pass) {
		// TODO Auto-generated method stub
		
	}

	private static void f1() {
		String[] strArray = { "10", "2a" };
		int value = 0;
		for (int i = 0; i <= 2; i++) {
			try {
				value = Integer.parseInt(strArray[i]);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("인덱스를 초과했음");
			} catch (NumberFormatException e) {
				System.out.println("숫자로 변환할 수 없음");
			} finally {
				System.out.println(value);
			}
		}

	}
}
