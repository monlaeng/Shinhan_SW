package com.shinhan.day06.LAB;

//abstract class : abstract 메서드가 1개 이상 있다를 의미한다.
//abstract method : 정의는 있고 구현은 상속받은 자식이 한다.
public abstract class Shape {

	private String color;
	private String type;
	
	public Shape() {}
	
	public Shape(String color, String type)
	{
		this.color = color;
		this.type = type;
	}
	
	public String getColor()
	{
		return color;
	}
	public String getType()
	{
		return type;
	}
	
	public abstract double calculateArea();
	
	public abstract double calculatePerimeter();
	
	@Override
	public String toString()
	{
		return color + " " + type;
	}
	
}

class Rectangle extends Shape{
	double length, width;
	
	public Rectangle(String color, double length, double width){
		super(color, "Rectangle");
		this.length = length;
		this.width = width;
			
	}
	public double calculateArea() {
		return width*length;
		
	}
	public double calculatePerimeter() {
		return 2*(width+length);
		
	}
}

class Circle extends Shape{
	double radius;
	double circumference;
	
	public Circle(String color, double radius){
		super(color, "Circle");
		this.radius = radius;
		
	}
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double calculateArea() {
		return radius*radius*Math.PI;
		
	}
	public double calculatePerimeter() {
		circumference = 2 * Math.PI * radius;
		return circumference;
		
	}
}


