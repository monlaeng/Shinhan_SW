package com.shinhan.day04.lab5;

public class EmployeeExam {

	public static void main(String[] args) {
		Employee[] emp = new Employee[4];
		emp[0] = new Employee("이부장", "부장", 1500000);
		emp[1] = new Employee("김과장", "과장", 1300000);
		emp[2] = new Employee("최대리", "대리", 1200000);
		emp[3] = new Employee("박사원", "사원", 1000000);
		
		for(Employee arr : emp) {
			arr.print();
		}
	}

}