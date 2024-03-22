package com.shinhan.day07;

public class InnerInterfaceTest {

	public static void main(String[] args) {
		OkButtonListener ok1 = new OkButtonListener();
		OkButtonListener2 ok2 = new OkButtonListener2();

		Button button = new Button();
		
		
		//익명 구현class만들기 
		Button.ClickListener ok3 = new Button.ClickListener() {
			
			@Override
			public void onClick() {
				System.out.println("익명 구현class만들기");
				
			}
		};
		
		//익명 구현class만들기2 
		button.setListener(new Button.ClickListener() {
			
			@Override
			public void onClick() {
				System.out.println("익명 구현class만들기2");
				
			}
		});
		
		
		//람다식(interface에 메서드가 1개있을때만 가능)
		button.setListener(()->System.out.println("익명 구현class만들기3"));
		button.click();
				
	}

}
