package com.shinhan.day05.lab;

public class Account {
	private String accNo;
	private String owner;
	private int balance;
	
	public Account(String accNo, String owner, int balance) {
		this.accNo = accNo;
		this.owner = owner;
		this.balance = balance;
		System.out.println("결과:계좌가 생성되었습니다.");
	}
	public void save(int amount) {
		balance += amount;
	}
	public int withdraw(int amount) {
		if(balance >= amount) {
			balance -= amount;
			System.out.println("결과:출금이 성공되었습니다.");
			return amount;
		} else {
			System.out.println("잔고부족");
			return 0;
		}
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	
}
