package com.shinhan.day04.lab5;

public class Employee {
	private String name;
	private String title;
	private int baseSalary;
	private int totalSalary;
	
	public Employee(String name, String title, int baseSalary) {
		this.name = name;
		this.title = title;
		this.baseSalary = baseSalary;
		getTotalSalary();
	}
	
	public void getTotalSalary() {
		if(title.equals("부장")) {
			totalSalary = (int) (baseSalary + baseSalary*0.25);
		} else if(title.equals("과장")) {
			totalSalary = (int) (baseSalary + baseSalary*0.15);
		} else {
			totalSalary = (int) (baseSalary + baseSalary*0.05);
		}
	}
	
	public void print() {
		System.out.printf("%s 직급의 %s씨의 본봉은 %d 원이고 총급여는 %d 원입니다 \n", title, name, baseSalary, totalSalary);
	}
}
