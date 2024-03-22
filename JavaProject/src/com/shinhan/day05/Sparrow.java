package com.shinhan.day05;

public class Sparrow  {
	private String name;
	private int legs;
	private int length;
	
	public Sparrow(String name, int legs, int length) {
		this.name = name;
		this.legs = legs;
		this.length = length;
	}
	
	void fly() {
		System.out.printf(getClass().getSimpleName() + "(%s)는 날아다닙니다.\n", name);
	}
	void sing() {
		System.out.printf(getClass().getSimpleName() + "(%s)는 소리내어 웁니다.\n",name);
	}
	void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "의 이름은 " + name + " 입니다. 다리는 " + legs + "개이고 길이는 " + length + "입니다.";
	}

}
