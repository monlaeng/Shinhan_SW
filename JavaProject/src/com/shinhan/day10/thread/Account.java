package com.shinhan.day10.thread;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Account {
	String accountNo;
	String ownerName;
	int balance;
	
	void deposit(int amount) {
		balance += amount;
	}
	int withdraw(int amount) {
		if(balance < amount) {
			System.out.println("잔고부족");
			return 0;
		}
		balance -= amount;
		return amount;
	}
	
}
