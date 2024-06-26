package com.shinhan.day06;

//extends Object는 생략되어 있음
//JavaBeans 기술 규격서 : field는 접근제한자를 private, 외부에서는 getter/setter로 접근

//1.final : 최종을 의미한다.
//2.final class :상속불가
//3.final field : 1회만 할당(선언 시, 생성시), 수정불가
//4.final static field: 랑수(1회 할당, 선언 시 또는 static block)
//5.final method : 재정의불가
/**
 * 
 */
public class Account extends Object {

	private final String name = "우리은행";
	private final String name2;
	private static final String NAME3 = "우리은행";
	private static final String NAME4;
	static {
		NAME4 = "우리은행";
	}

	final void method1() {
		System.out.println("재정의 할 수 없다.");
	}

	private String accountNo;
	private String ownerName;
	private int balance;

	// 생성자 : 정의하지 않으면 컴파일러가 default 생성자를 만든다.
	// 정의하면 만들어주지 않는다.
	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		this.name2 = "";

	}

	void deposit(int amount) {
		balance += amount;
	}

	int withdraw(int amount) {
		if (balance < amount) {
			System.out.println("잔고부족, 출금불가");
			return 0;
		}

		balance -= amount;
		return amount;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", name2=" + name2 + ", accountNo=" + accountNo + ", ownerName=" + ownerName
				+ ", balance=" + balance + "]";
	}

	protected String title = "protected field연습";
	protected void print() {
		System.out.println("protectd접근제한자연습");
		
	}
}
