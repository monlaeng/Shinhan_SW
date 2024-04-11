package com.shinhan.project0;

import java.util.List;
import java.util.Scanner;

//service, dao는 업무만큼 생성(조인할 경우도 따로 dao 생성), dto도 테이블별 생성
//controller&view 는 하나

public class Controller {
	static Scanner sc = new Scanner(System.in);


	public static void main(String[] args) {
		
		boolean isStop = false;
		RentalService rentService = new RentalService();
		ReturnService returnService = new ReturnService();
		CloseService closeService =new CloseService();
		ShowService showService =new ShowService();
		while(!isStop) {
			int select = menu();
			switch(select) {
			case 0 -> {
				System.out.println("종료합니다.");
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
				List<ProductDTO> prodlist = showService.showProd();
				View.print(prodlist, "<물품 리스트>");
			}
			case 3 -> {
				System.out.print("전화번호 입력 > ");
				String phone = sc.next();
				String returnProd = returnService.returnProd(phone);
				System.out.println(returnProd);
			}
			case 4 -> {
				System.out.print("패스워드 입력 > ");
				String password = sc.next();
				if(password.equals("admin")) {
					switch(adminMenu()) {
					case 1 -> {
						int proceeds = showService.showAccount();
						System.out.println("오늘의 정산금액은 " + proceeds + "원입니다.");
					}
					case 2 -> {
						closeService.closeAll();
						System.out.println("정산 완료했습니다.");
					}
					}
				} else {
					System.out.println("패스워드가 일치하지 않습니다.");
				}
			}
			default -> {
				System.out.println("제공하지 않는 서비스입니다.");
			}
			}
		}
		sc.close();

	}

	private static int adminMenu() {
		System.out.println("====================================");
		System.out.println("1. 오늘의 정산금 확인");
		System.out.println("2. 전체 정산하기");
		System.out.print("선택 > ");
		int select = sc.nextInt();
		
		return select;
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
		System.out.println("0. 종료");
		System.out.println("1. 대여");
		System.out.println("2. 조회");
		System.out.println("3. 반납");
		System.out.println("4. 관리자 로그인");
		System.out.print("선택 > ");
		int select = sc.nextInt();
		
		return select;
	}
	
	private static String phone() {
		System.out.print("전화번호를 입력하세요. ex)010-0000-0000 > ");
		String phone = sc.next();
		
		return phone;
	}
	

}
