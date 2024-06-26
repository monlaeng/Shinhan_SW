package com.shinhan.day06;

public class CreditLineAccount extends Account{

	int creditLine;		//마이너스 한도

	public CreditLineAccount(String accountNo, String ownerName, int balance, int creditLine) {
		super(accountNo, ownerName, balance);
		this.creditLine = creditLine;
	}
	
	//인출한다 메서드는 부모의 로직을 사용한다. ... 재정의롤 원한다.
	//override(재정의, 덮어쓰기)
	//이름, 매개변수 타입과 개수, return 모두 같아야한다. modifier는 같거나 더 넓어져야한다.
	
	@Override
	public int withdraw(int amount) {
		if (getBalance() + creditLine < amount) {
			System.out.println("잔고부족, 출금불가");
			return 0;
		}
			
		setBalance(getBalance() - amount);
		return amount;
	}
	
//	Book f1() {
//		return new Book("AA", 1000);
//	}
}
//
//class Book{
//	String title;
//	int price;
//	Book(String title, int price) {
//		this.title = title;
//		this.price = price;
//	}
//}
