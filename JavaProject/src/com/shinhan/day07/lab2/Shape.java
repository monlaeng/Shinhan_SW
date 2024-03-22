package com.shinhan.day07.lab2;

public abstract class Shape {
	int numSides;	//변의 수
	
	Shape(int numSides){
		this.numSides = numSides;
	};
	
	int getNumSides(){
		return numSides;
	};
	
	public abstract double getArea();	//넓이
	public abstract double getPerimeter();	//둘레 길이
}
