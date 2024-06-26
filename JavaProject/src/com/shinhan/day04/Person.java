package com.shinhan.day04;

public class Person {
	static int numberOfPersons;
	int age;
	String name;
	
	Person() {
		this(12, "Anonymous");
	}
	
	Person(int age, String name) {
		this.age = age;
		this.name = name;
		numberOfPersons++;
	}
	
	void selfIntroduce() {
		System.out.println("내 이름은 "
				+ name
				+ " 이며, 나이는 "
				+ age
				+ " 살 입니다. ");
	}
	int getPopulation() {
		return numberOfPersons;
	}
}
