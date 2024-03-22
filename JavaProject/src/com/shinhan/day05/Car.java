package com.shinhan.day05;

//class : object를 만들기 위한 틀(template), 설계도
//object : class를 이용해서 만든 독립된 개체
//instance : object, new로 만든 실체
public class Car {
	//1. field(특징, data저장, 변수) : static(class 변수, object 들의 공통변수), 
	// non-static (instance 변수, 멤버변수), new 시에 자동으로 초기화된다.
	static String company = "현대자동차";	//class가 load 시에 값이 활용된다.
	static int carCount;
	private String model;
	private int price;
	//2. constructor [method]...컴파일시에 정의가 없으면 자동으로 default 생성자(argument 없음)를 만들어준다.
	//객체생성시 자동으로 호출된다. new Car();
	//생성자는 생성 시 값 초기화가 목적이다.
	//매개변수 이름과 맴버변수 이름 충돌발생, 이를 구분하기 위해 현재객체를 this라고 사용한다.
	//생성자의 overloading(이름 같고, 매개변수 사양이 다르다.)
	//하나의 생성자가 같은 이름의 다른 모양의 생성자를 호출 시 사용한다. this()
	Car(String model, int price) {		//parameter에 들어간 변수는 항상 지역변수이다.
		//함수이름(변수타입 매개변수) : 매개변수는 지역변수
		this.model = model;
		this.price = price; 
		carCount++;
		System.out.println(carCount + "번째 자동차가 만들어집니다.");
	}
	Car(String model) {
		this(model, 1000);
	}	
	Car(int price) {
		this("이름 미정", price);
	}
	
	//3. 일반 method(기능구현{}, 문장들의 묶음), 반드시 return 값의 타입을 정의한다. return 값이 없으면 void.
	void carInfoPrint(String title) {
		System.out.println(title);
		System.out.println("company : " + company);
		System.out.println("carCount : " + carCount);
		System.out.println("model: " + model);
		System.out.println("price : " + price);
	}
	//Getter & Setter는 이용규칙을 지킨다.자바기술에 JavaBeans기술에서 사용하기 때문

	public static String getCompany() {
		return company;
	}

	public static void setCompany(String company) {
		Car.company = company;
	}

	public static int getCarCount() {
		return carCount;
	}

	public static void setCarCount(int carCount) {
		Car.carCount = carCount;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	static void carInfoPrint2(String title) {
		System.out.println(title);
		System.out.println("company : " + company);
		System.out.println("carCount : " + carCount);
		//***불가(static method에서 non-static(instance 변수) 사용불가
//		System.out.println("model: " + model);
//		System.out.println("price : " + price);
	}
	//4. block
	//5. inner class
	
}
