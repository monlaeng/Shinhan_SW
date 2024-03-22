package com.shinhan.day05;

public class Employee {
	private String name;
	private int age;
	private String dept;
	
	
	public Employee(String name, int age, String dept) {
		this.name = name;
		this.age = age;
		this.dept = dept;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}

	void print() {
		System.out.printf("이  름 : %s  나 이 : %d  부  서 : %s \n", name, age, dept);
	}
}
