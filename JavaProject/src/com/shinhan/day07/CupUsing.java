package com.shinhan.day07;

public class CupUsing {
	public static void main(String[] args) {
		print(new CoffeeCup());
		print(new WaterCup());
		print(new Cup() {
			public void use() {
				System.out.println("익명구현 class");
			}
		});
		print(() -> System.out.println("람다표현식으로 구현 class만들기"));
	}
	static void print(Cup cup) {
		cup.use();
	}
}
