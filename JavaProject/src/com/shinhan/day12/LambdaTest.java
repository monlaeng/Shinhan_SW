package com.shinhan.day12;

@FunctionalInterface
interface Calcuable {
	double calc(double x, double y);
}

//구현class
class MyCalculator implements Calcuable{

	@Override
	public double calc(double x, double y) {
		return x+y;
	}
	
}

class Computer{
	public static double staticMethod(double x, double y) {
		return x+y;
	}
	
	public double instanceMethod(double x, double y) {
		return x+y;
	}
}

@FunctionalInterface
interface Comparable2{
	int compare(String a, String b);
}

interface Creatable{
	public Student create(String name, int score);
}

class Person {
	public Student getStudent(Creatable creatable, String name, int score) {
		return creatable.create(name, score);
	}
}


public class LambdaTest {
	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
		f5();
	}

	private static void f5() {
		Person p1 = new Person();
		Creatable creatable1 = new Creatable() {
			@Override
			public Student create(String name, int score) {
				return new Student(name, score);
			}
		};
		Student s = p1.getStudent(creatable1, "홍길동1", 200);
		System.out.println(s);
		
		Creatable creatable2 = (String name, int score) -> new Student(name, score);
		Student s2 = p1.getStudent(creatable1, "홍길동2", 200);
		System.out.println(s2);
		
		Creatable creatable3 = Student::new;
		Student s3 = p1.getStudent(creatable1, "홍길동3", 200);
		System.out.println(s3);
		
	}

	private static void f4() {
		Student s = new Student("홍길동",100);
		Student s2 =makeStduent("홍길동",100);
	}

	private static Student makeStduent(String name, int score) {
		return new Student(name,score);
	}

	private static void f3() {
		String s1 = "A";
		String s2 = "C";
		//Comparable2 comp = (String a, String b)-> a.length()-b.length();
//		Comparable2 comp = (a, b)-> a.length()-b.length();
		Comparable2 comp = String::compareToIgnoreCase;
		int result = comp.compare(s1, s2);
		System.out.println(result);
	}

	private static void f2() {
		System.out.println("1.구현class이용");
		MyCalculator a = new MyCalculator();
		System.out.println("result = " + a.calc(1, 2));
		
		System.out.println("2.익명구현class이용");
		Calcuable b = new Calcuable() {
			@Override
			public double calc(double x, double y) {
				return x-y;
			}
		};
		System.out.println("result = " + b.calc(1, 2));

		System.out.println("3.람다표현식");
		//Calcuable c = (double x, double y)-> x*y;
		//Calcuable c = (x, y)-> x*y;
		Calcuable c = (x, y)-> {return x*y;};
		System.out.println("result = " + c.calc(1, 2));

		//스테틱메서드
		Calcuable d = Computer::staticMethod;
		System.out.println("result = " + d.calc(1, 2));
		
		//인스턴스메서드
		Computer computer = new Computer();
		Calcuable e = computer::instanceMethod;
		System.out.println("result = " + e.calc(1, 2));		
	}

	private static void f1() {
		Thread t1 = new Thread() {
			public void run() {
				System.out.println("Thread구현");
			}
		};
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Thread구현...Runnable interface구현");
			}
		});
		
		Thread t3 = new Thread(()-> {
			System.out.println("Thread구현...Runnable interface구현");
		});

	}

}
