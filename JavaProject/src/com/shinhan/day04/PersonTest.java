package com.shinhan.day04;

public class PersonTest {

	public static void main(String[] args) {
		Person pe1 = new Person(20, "김아무개");
		System.out.printf("전체 인구수는 %d 명입니다.\n",pe1.getPopulation());
		
		Person pe2 = new Person(10, "이아무개");
		Person pe3 = new Person();
		System.out.printf("전체 인구수는 %d 명입니다.\n",pe3.getPopulation());

		Person pe4 = new Person(15, "박아무개");
		Person pe5 = new Person();
		System.out.printf("전체 인구수는 %d 명입니다.\n",pe5.getPopulation());

		
		pe1.selfIntroduce();
		pe3.selfIntroduce();
		
		
	}

}
