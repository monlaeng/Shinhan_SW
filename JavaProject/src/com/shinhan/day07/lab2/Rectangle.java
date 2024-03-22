package com.shinhan.day07.lab2;

public class Rectangle extends Shape implements Resizable{
	double width;
	double height;
	public Rectangle(double width,double height) {
		super(4);
		this.height = height;
		this.width = width;
	}
	@Override
	public void resize(double s) {
		width *=  s; 
		height *=  s; 
		
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return width*height;
	}
	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 2*(width + height);
	}
}