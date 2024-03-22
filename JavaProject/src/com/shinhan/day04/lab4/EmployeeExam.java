package com.shinhan.day04.lab4;

public class EmployeeExam {

	public static void main(String[] args) {
		Employee emp = new Employee("123", "홍길동", 100);
		emp.setId("555");
		emp.setName("심은정");
		emp.setBaseSalary(200);
		
		System.out.println(emp.toString());
		System.out.println(emp);
		
		Book book = new Book("자바", 3);
		System.out.println(book);
		System.out.println(book.toString());
		
	}

}
