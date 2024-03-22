package com.shinhan.day07.CH8;

public class CarExample {
	public static void main(String[] args) {
		Car myCar = new Car();
		//instance inner class
		Car.Tire tire = myCar.new Tire();
		//static inner class
		Car.Engine engine = new Car.Engine();
		
		//local class는 method내에서 접근, 외부접근불가
		myCar.method();
		}
}
