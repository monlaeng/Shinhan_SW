package com.shinhan.day11;

public class User2Thread extends Thread {
	private Calculator;
	
	public User2Thread() {
		setName("User2Thread");
	}
	
	public void setCalculastor(Calculator calculator) {
		this.calculator = calculator;
	}
	
	@Override
	public void run() {
		calculator.serMemory2(50);
	}

}
