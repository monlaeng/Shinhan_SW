package com.shinhan.day05.lab;

import java.util.Scanner;

//함수, 메서드 : 문장들의 묶음, 로직구현
public class BankApplication {
	static Scanner sc = new Scanner(System.in);


	public static void main(String[] args) {
		boolean isStop = false;
		Account[] arr = new Account[5];
		int index = 0;
		while(!isStop) {
			menu();
			String choice = sc.nextLine();
			switch(choice) {
			case "1" -> {
				menuPrint("계좌생성");
				if(index == arr.length) {
					System.out.println("더이상 계좌생성 불가합니다.");
				} else {
					createAccount(arr, index++);
				}
			}
			case "2" -> {
				menuPrint("계좌목록");
				for(Account acc:arr) {
					if(acc==null) {
						break;
					}
					System.out.printf("%10s %10s %10d \n",acc.getAccNo(), acc.getOwner() ,acc.getBalance());
				}
			}
			case "3" -> {
				menuPrint("예금");
				inputAccount(arr,index);
				
			}
			case "4" -> {
				menuPrint("출금");
				outputAccount(arr, index);
			}
			case "5" -> {
				isStop = true;
			}
			}
		}
		System.out.println("프로그램 종료");
		sc.close();
	}

	private static void outputAccount(Account[] arr, int index) {
		System.out.print("계좌번호: ");
		String accNo = sc.nextLine();
		System.out.print("예금액: ");
		int amount = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < index; i++) {
			if(accNo.equals(arr[i].getAccNo())) {
				int amount2 = arr[i].withdraw(amount);
				System.out.println(amount2 + "원 출금되었습니다.");
				break;
			}
		}		
	}

	private static void inputAccount(Account[] arr, int index) {
		System.out.print("계좌번호: ");
		String accNo = sc.nextLine();
		System.out.print("예금액: ");
		int amount = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < index; i++) {
			if(accNo.equals(arr[i].getAccNo())) {
				arr[i].save(amount);
				break;
			}
		}
	}

	private static void createAccount(Account[] arr, int index) {
		System.out.print("계좌번호: ");
		String accNo = sc.nextLine();
		System.out.print("계좌주: ");
		String owner = sc.nextLine();
		System.out.print("초기입금액: ");
		int balance = sc.nextInt();
		sc.nextLine();
		arr[index++] = new Account(accNo, owner, balance);	
		
	}
	private static void menuPrint(String title) {
		System.out.println("--------------");
		System.out.println(title);
		System.out.println("--------------");
	}

	private static void menu() {
		System.out.println("-----------------------------------------");
		System.out.println("  1.계좌생성|2.계좌목록|3.예금|4.출금|5.종료");
		System.out.println("-----------------------------------------");
		System.out.printf("선택>");
	}
	

}