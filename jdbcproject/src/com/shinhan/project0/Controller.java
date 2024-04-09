package com.shinhan.project0;

import java.util.Scanner;

//service, dao는 업무만큼 생성(조인할 경우도 따로 dao 생성), dto도 테이블별 생성
//controller&view 는 하나

public class Controller {
	static Scanner sc = new Scanner(System.in);


	public static void main(String[] args) {
		//테이블 생성 & 초기 데이터 삽입
		TableService tableService = new TableService();
		int tableResult = tableService.createTable();
		System.out.println(tableResult == 0 ? "테이블 생성 성공" : "테이블 생성 실패"); 
		int setSequence = tableService.setSeq();
		System.out.println(setSequence == 0 ? "sequence 입력 성공" : "입력 실패");
		int setProd = tableService.setProduct(); 
		System.out.println(setProd > 0 ? "product 입력 성공" : "product 입력 실패");
		boolean setAcc = tableService.setAccount();
		System.out.println(setAcc == false ? "account 입력 성공" : "account 입력 실패");
		int setCust = tableService.setCustomer();
		System.out.println(setCust >0 ? "customer 입력 성공" : "customer 입력 실패");
		int setRent = tableService.setRental();
		System.out.println(setRent > 0 ? "rentar 입력 성공" : "rentar 입력 실패");
		
		boolean isStop = false;
		RentalService rentService = new RentalService();
		while(!isStop) {
			int select = menu();
			switch(select) {
			case 0 -> { 
				System.out.println("0. 마감");
				isStop = true;
				}
			case 1 -> {
				int rentmenu = rentalMenu();
				System.out.print("전화번호 입력 > ");
				String phone = sc.next();
				String rentResult = rentService.rent(rentmenu, phone);
				System.out.println(rentResult);
			}
			case 2 -> {
				System.out.println("2. 조회");

			}
			case 3 -> {
				System.out.println("3. 반납");
			}
			}
		}
		sc.close();

	}

	private static int rentalMenu() {
		System.out.println("====================================");
		System.out.println("1. 돗자리 : 4000원");
		System.out.println("2. 텐트 : 6000원");
		System.out.println("3. 담요 : 1000원");
		System.out.println("4. 테이블 : 2000원");
		System.out.println("5. 스피커 : 2000원");
		System.out.println("6. 무드등 : 1000원");
		System.out.print("선택 > ");
		int select = sc.nextInt();
		
		return select;
	}

	private static int menu() {
		System.out.println("====================================");
		System.out.println("0. 마감");
		System.out.println("1. 대여");
		System.out.println("2. 조회");
		System.out.println("3. 반납");
		System.out.print("선택 > ");
		int select = sc.nextInt();
		System.out.println("====================================");
		
		return select;
	}
	
	private static String phone() {
		System.out.print("전화번호를 입력하세요. ex)010-0000-0000 > ");
		String phone = sc.next();
		
		return phone;
	}
	

}
