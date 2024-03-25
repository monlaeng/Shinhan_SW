package com.shinhan.day10;

public class CoffeeAgency<P> implements Rentable<CoffeeMachine>{

	@Override
	public void method1() {
		
	}

	@Override
	public CoffeeMachine rent() {

		return new CoffeeMachine();
	}
	
	public void method1(CoffeeMachine coffee) {
		coffee.method1();
	};

}
