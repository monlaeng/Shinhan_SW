package com.shinhan.day08.CH12;

import java.util.Objects;

public class Student {
	private String studentNum;

	public Student(String studentNum) {
		this.studentNum = studentNum;
	}

	public String getStudentNum() {
		return studentNum;
	}

	@Override
	public int hashCode() {
		final int prime = 3;
		return prime;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Student st1)) return false;
	
		return this.studentNum.equals(st1.studentNum);
	}
	

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Student other = (Student) obj;
//		return Objects.equals(studentNum, other.studentNum);
//	}
	
	
}