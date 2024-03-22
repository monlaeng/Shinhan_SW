package com.shinhan.day05;

/*접근지정자(Modifier)
1. public : 모든 패키지에서 접근이 가능
2. protected : 같은 패키지ㅔ서 접근 가능, 다른 패키지인 경우는 상속 받으면 접근가능
3. 생략 : 같은 패키지에서 접근 가능
4. private : 같은 class 내에서 접근가능 (정보은닉, 캡슐화)
*/
//class 접근 지정자는 public, 생략 둘 중 하나이다.
public class Computer {
	private String model;
	protected int price;
	public Computer() {
		System.out.println("default 생성자 정의");
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	
}
