package com.shinhan.day07.CH8;



interface Action {
	public void work();
}

public class ActionExample {

	public static void main(String[] args) {
		Action action = new  Action() {
			public void work() {
				System.out.println("익명구현객체");
			}
		};
		Action action2 =()->System.out.println("Lambda표현식");
			 
		action.work();
		action2.work();
	}
}