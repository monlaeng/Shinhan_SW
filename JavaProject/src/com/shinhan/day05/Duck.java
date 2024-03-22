package com.shinhan.day05;

public class Duck {
	private String name;
	private int legs;
	private int length;
	
	public Duck(String name, int legs, int length) {
		this.name = name;
		this.legs = legs;
		this.length = length;
	}
	
	void fly() {
		System.out.printf(getClass().getSimpleName() + "(%s)는 날지 않습니다.\n", name);
	}
	void sing() {
		System.out.printf(getClass().getSimpleName() + "(%s)는 소리내어 웁니다.\n", name);
	}
	void setName(String name) {
		this.name = name;
	}

	//재정의 : 함수이름, 매개변수, returnType이 가타야한다.
	//Modifier는 같거나 더 넓어져야한다.
	@Override
	public String toString() {
		return getClass().getSimpleName() + "의 이름은 " + name + " 입니다. 다리는 " + legs + "개이고 길이는 " + length + "입니다.";
	}

}
