package com.shinhan.dept;

import java.util.List;

public class DeptView {

	public static void print(List<DeptDTO> deptlist, String title) {
		System.out.printf("===============%s==============\n", title);
		deptlist.stream().forEach(dept -> {
			if(dept == null) {
				System.out.println("존재하지 않는 부서입니다.");
			} else {
				System.out.println("-------------------------------------");
				System.out.println("부서번호 : " + dept.getDepartment_id());
				System.out.println("부서이름 : " + dept.getDepartment_name());
				System.out.println("매니져 번호 : " + (dept.getManager_id() == 0 ? "미배정" : dept.getManager_id()));
				System.out.println("지역번호  : " + dept.getLocation_id());
			}
		});
	}

	public static void print(DeptDTO dept, String title) {
		System.out.printf("===============%s==============\n", title);
		if(dept == null) {
			System.out.println("존재하지 않는 부서입니다.");
		} else {
			System.out.println("-------------------------------------");
			System.out.println("부서번호 : " + dept.getDepartment_id());
			System.out.println("부서이름 : " + dept.getDepartment_name());
			System.out.println("매니져 번호 : " + (dept.getManager_id() == 0 ? "미배정" : dept.getManager_id()));
			System.out.println("지역번호  : " + dept.getLocation_id());
		}
	}

	public static void print(String message) {
		System.out.printf("===============%s==============\n", message);		
	}
}
