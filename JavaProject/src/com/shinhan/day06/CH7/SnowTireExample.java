package com.shinhan.day06.CH7;

public class SnowTireExample {
	public static void main(String[] args) {
		SnowTire snowTire = new SnowTire();
		
		//자동형변환
		//부모 = 자식
		Tire tire = snowTire;
		
		snowTire.run();
		snowTire.run2();
		snowTire.run3();
	
		//메서드는 타입을 따른다. Override 되어있다면 재정의된 메서드가 호출된다.
		tire.run();
		tire.run2();
		//tire.run3();  ... 불가능
		
		//강제형변환
		
		((SnowTire)tire).run3();
		if(tire instanceof SnowTire snow) {
			snow.run3();
		} 
		
		//Tire cannot be cast to class SnowTire
		Tire tire2 = new Tire();
		SnowTire ss = (SnowTire) tire2;

	}
}
