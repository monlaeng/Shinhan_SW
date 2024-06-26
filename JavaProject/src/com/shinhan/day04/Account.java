package com.shinhan.day04;

public class Account {
	String accNo;
	int balance;
	
	Account(String accNo, int balance) {
		this.accNo = accNo;
		this.balance = balance;
		System.out.println(accNo + " 계좌가 개설되었습니다.");
		System.out.println(accNo + "계좌의 잔고는 " + balance + "입니다.");
	}
	
	void deposit(int inc) {
		this.balance += inc;
		System.out.printf("%s 계좌에 %d원이 입금되었습니다.\n", this.accNo,inc);
		System.out.printf("%s 계좌의 잔고는 %d원입니다.\n", this.accNo, this.balance);
	}
	
	void withdraw(int dec) {
		this.balance -= dec;
		System.out.printf("%s 계좌에 %d원이 출금되었습니다.\n", this.accNo,dec);
		System.out.printf("%s 계좌의 잔고는 %d원입니다.\n", this.accNo, this.balance);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}


	
}
