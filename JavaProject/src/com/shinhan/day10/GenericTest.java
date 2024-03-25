package com.shinhan.day10;

public class GenericTest {
	
	public static void main(String[] args) {
		Product<Double, Integer> p1 = makeProduct2(3.14, 200);

		boolean result = compare(10, 20);
		System.out.println(result);
	}
	
	private static <T extends Number> boolean compare(T i, T j) {
		double d1 = i.doubleValue();
		double d2 = j.doubleValue();
		
		return d1 == d2;
	}

	//제한된 타입 파라메터
	private static <A extends Number, B> Product<A, B> makeProduct2(A i, B j) {
		Product <A, B> p = new Product<A, B>(i, j);
		return null;
	}

	public static void main4(String[] args) {
		Product<String, Integer> p1 = makeProduct("A", 100);
		Product<Integer,String > p2 = makeProduct(200, "B");
		Product<String, String> p3 = makeProduct("C", "D");

		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
	
	}
	
	private static <A, B> Product<A, B> makeProduct(A a, B b) {
		Product<A, B> p = new Product<>(a, b);
		return p;
	}

	public static void main3(String[] args) {
		Box<String> result1 = makeBox("구체적타입 사용 시 결정");
		Box<Integer> result2 = makeBox(100);
		Box<Car> result3 = makeBox(new Car());
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		
	}
	
	private static <T> Box<T> makeBox(T str) {
		Box<T> box = new Box<T>(str); 
		return box;
	}

	public static void main2(String[] args) {
		Box<String> result1 = boxing("문자");
		Box<Integer> result2  = boxing(100);
		Box <TV> result3 = boxing(new TV());
		Box <Home> result4 = boxing(new Home());
		Box<Product<String, Integer>> result5 = boxing(new Product<>("A", 100));
		Box<ChildProduct<String, Integer, String>> result6 = boxing(new ChildProduct<> ("A", 12, "B"));
		System.out.println(result1.getContent());
		System.out.println(result2.getContent());
		System.out.println(result3.getContent());
		System.out.println(result4.getContent());
		System.out.println(result5.getContent());
		System.out.println(result6.getContent());
	}

	//<P>가 제네릭이다. 구체적인 타입이 아니다.
	//Box<p> : return 타입, 제네릭 타입읜 Box를 return한다.
	private static <P> Box<P> boxing(P p) {
		Box<P> box = new Box<>();
		box.setContent(p);
		return box;
	}

	private static void f6() {
		ChildProduct<String, Integer, Integer> p1 = new ChildProduct<>("", 10, 20);
		System.out.println(p1.price);
		System.out.println(p1);
	}

	private static void f5() {
		CoffeeAgency coffeAgency = new CoffeeAgency();
		CoffeeMachine machine = coffeAgency.rent();
		machine.method1();
		
		coffeAgency.method1(machine);
	}

	private static void f4() {
		HomeAgency homeAgency = new HomeAgency();
		Home home = homeAgency.rent();
		home.turnOnLight();
		
		CarAgency carAgency = new CarAgency();
		Car car = carAgency.rent();
		car.run();
		
		
	}

	private static void f3() {
		Product<String, Integer> p1 = new Product<String, Integer>();
		p1.setKind("ABC");
		p1.setModel(200);
		Product<String, Integer> p2 = new Product<String, Integer>("컴퓨터", 100);
		System.out.println(p1);
		System.out.println(p2);
	
		Product<CoffeeMachine, String> p3 = new Product<CoffeeMachine, String>(new CoffeeMachine(), "DDD");
		System.out.println(p3);
		
	}
	

	private static void f2() {
		//제네릭사용목적 : 컴파일 시에 타입을 제한하기(잘못된 타입 입력불가, 얻을 때 형변환 불필요)
		Box<CoffeeMachine> box1 = new Box<CoffeeMachine>();
		box1.setContent(new CoffeeMachine());
		CoffeeMachine a = box1.getContent();
		System.out.println(a);
	}

	private static void f1() {
		Box box1 = new Box();
		box1.setContent(100);
		box1.setContent("100");
		box1.setContent(new CoffeeMachine());
		
		
		box1.getContent();
	}
}
