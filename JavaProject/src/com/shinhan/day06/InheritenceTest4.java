package com.shinhan.day06;

//구현 : {}
//추상 : 정의는 있고 구현은 없다. 구현은 자식 class가 한다.
//abstract method : 정의는 있고 구현은 업사.
//abstract class : class 안에 추상 메서드가 하나라도 있다.
//추상메서드를 상속받은 자식은 반드시 추상메서드를 구현할 의무가 있다. 
abstract class Vehicle {	//안에 추상메서드가 하나라도 있기 때문에 추상 클래스이다.
	abstract void run();	//정의는 있지만 {} 구현이 없다.
	void print() {
		System.out.println("일반 메서드");
	}

}

class Bus extends Vehicle {

	void run() {
		System.out.println("(Bus)자식의 override... 메서드");
	}

}

abstract class Truck extends Vehicle {
	abstract void run();
	void print2() {
		System.out.println("구현메서드");
	}
}

class Truck2 extends Truck {
	void run() {
		System.out.println("추상메서드는 반드시 자식이 구현할 의무가 있다.");
	}
}

class Taxi extends Vehicle {
	void run() {
		System.out.println("(Taxi)자식의 override.... 메서드");
	}
}

class Driver {
	void drive(Vehicle vv) {
		vv.run();
	}
}

class Tire {
	void roll() {
		System.out.println("부모가 정의 roll()");
	}
}

class HankookTire extends Tire {
	void roll() {
		System.out.println("HankookTire 정의 roll()");
	}
}

class KumhoTire extends Tire {
	void roll() {
		System.out.println("HankookTire 정의 roll()");
	}
}

class Car {
	Tire tire;

	Car(Tire tire) {
		this.tire = tire;
	}

	void go() {
		tire.roll();
	}
}

public class InheritenceTest4 {

	public static void main(String[] args) {
		System.out.println("-----매개변수의 다형성");

		Driver driver = new Driver();
		driver.drive(new Bus());
		driver.drive(new Taxi());

		System.out.println("-----field의 다형성");
		Car car1 = new Car(new HankookTire());
		Car car2 = new Car(new KumhoTire());
		car1.go();
		car2.go();
	}

}
