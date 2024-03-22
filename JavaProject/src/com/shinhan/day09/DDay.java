package com.shinhan.day09;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.regex.Pattern;

public class DDay {
	public static void main(String[] args) throws ClassNotFoundException {
		Class a = ComputerVO.class;
		Class b = new ComputerVO().getClass();
		Class c = Class.forName("com.shinhan.day09.ComputerVO");
		
		//a.getResource("")
	}
	
	public static void ex17(String[] args) {

		
		String id = "5Angel1004";
//		String regExp = "^[0-9][0-9A-Za-z]{8,12}";
		String regExp = "^[0-9]\\w{8,12}[^z]$";
		boolean isMatch = Pattern.matches(regExp, id);
		if (isMatch) {
			System.out.println("ID로 사용할 수 있습니다.");
		} else {
			System.out.println("ID로 사용할 수 없습니다.");
		}
	}


	private static void ex16(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 hh시 mm분");
		Date d = new Date();
		sdf.format(sdf.format(d));

	}

	private static void ex15() {
		LocalDateTime startDateTime = LocalDateTime.now();

		LocalDateTime endDateTime = LocalDateTime.of(startDateTime.getYear(), 12, 31, 0, 0, 0);
		LocalDateTime happyNew = LocalDateTime.of(startDateTime.getYear(), 1, 1, 0, 0, 0);

		long remainDay = startDateTime.until(endDateTime, ChronoUnit.DAYS);
		long remainDay2 = happyNew.until(startDateTime, ChronoUnit.DAYS);
		System.out.println("남은 일자 : " + remainDay);
		System.out.println("지나간 일자 : " + remainDay2);
	}
}
