package com.shinhan.dept;

import java.util.List;
import java.util.Scanner;

public class DeptController {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean isStop = false;
		DeptService deptService = new DeptService();
		
		while(!isStop) {
			int choice = menu();
			switch(choice) {
			case 0 -> {isStop = true;}
			case 1 -> {
				List<DeptDTO> deptlist = deptService.selectAll();
				DeptView.print(deptlist, "모두 출력");
			}
			case 2 -> {
				System.out.print("조회할 부서번호>> ");
				int deptid = sc.nextInt();
				DeptView.print(deptService.selectDept(deptid), "부서번호조회");
			}
			case 3 -> {
				DeptDTO dept = insertMenu();
				int result = deptService.deptInsert(dept);
				DeptView.print(result > 0? "입력성공" : "입력실패");
			}
			case 4 -> {			
				DeptDTO dept = insertMenu();
				int result = deptService.deptUpdate(dept);
				DeptView.print(result > 0? "수정성공" : "수정실패");}
			case 5 -> {}
			}
		}
		System.out.println("\t    *Menu END*");
	}

	private static DeptDTO insertMenu() {
		System.out.print("DEPARTMENT_ID >> ");
		int deptid = sc.nextInt();
		System.out.print("DEPARTMENT_NAME >> ");
		String deptname = sc.next(); 
		System.out.print("MANAGER_ID >> ");
		int mid = sc.nextInt();
		System.out.print("LOCATION_ID >> ");
		int lid = sc.nextInt();
		
		DeptDTO dept = new DeptDTO();
		
		dept.setDepartment_id(deptid);
		dept.setDepartment_name(deptname);
		dept.setLocation_id(lid);
		dept.setManager_id(mid);
		
		return dept;
	}

	private static int menu() {
		System.out.println("======================================");
		System.out.println("\t<Departments Menu>");
		System.out.println("0. 종료");
		System.out.println("1. 전체 부서 조회");
		System.out.println("2. 부서 번호 조회");
		System.out.println("3. 부서 입력");
		System.out.println("4. 부서 수정");
		System.out.println("5. 부서 삭제");
		System.out.print("선택 > ");
		int choice = sc.nextInt();
		System.out.println("======================================");
		
		return choice;
	}

}
