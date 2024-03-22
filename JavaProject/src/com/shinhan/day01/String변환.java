package com.shinhan.day01;

//JVM이 String 변환 클래스의 main() 메서드 호출을 위해 접근권한이 public이다.

public class String변환 {

	public static void main(String[] args) {
		f1();
	}

	private static void f1() {
		String score = "100";
		
		byte a = Byte.parseByte(score);
		short b = Short.parseShort(score);
		int c = Integer.parseInt(score);
		long d = Long.parseLong(score);
		float e = Float.parseFloat(score);
		double f= Double.parseDouble(score);
	}
}
