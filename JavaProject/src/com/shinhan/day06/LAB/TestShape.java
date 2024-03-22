package com.shinhan.day06.LAB;

public class TestShape {

	public static void main(String args[])
	{
		//배열생성
		Shape[] s = new Shape[3];
		
		s[0] = new Circle("BLUE", 10);
		s[1] = new Rectangle("RED", 5, 7);
		s[2] = new Circle("GREEN", 8);
		
		for(int i = 0 ; i < 3 ; i++)
		{
			print(s[i], i);
		}	
	}

	private static void print(Shape s, int i) {
		String result = (s instanceof Circle cir) ? ", a radius of "+ cir.getRadius()+"" : ""; 	
		System.out.println("Shape " + i + " is a " + s
			          + " with an area of " + s.calculateArea()
			          + result
			          + ", and a perimeter of " + s.calculatePerimeter());
	}
}


