package com.shinhan.emp;


import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.shinhan.util.DateUtil;

//사용자가 요청 -> Controller -> Service
//사용자 display<-View<-Controller<-Service
//나중에는 Servlet(서버에서 실행되는 자바 프로그램)으로 작성할 예정이다.

public class EmpController {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
//		EmpDAO dao = new EmpDAO();
//		dao.selectAll().stream()
//		.forEach(emp->System.out.println(emp));
		
		boolean isStop = false;
		EmpService empService = new EmpService();
		while(!isStop) {
			int selectJob = menuDisplay();
			switch(selectJob) {
			case 0 -> {
				isStop = true;
			}
			case 1 -> {
				List<EmpDTO> emplist =  empService.selectAll();
				EmpView.print(emplist, "모든 직원 조회");
			}
			case 2 -> {
				System.out.print("조회할 직원번호>> ");
				int empid = sc.nextInt();
				EmpView.print(empService.selectById(empid), "특정직원조회");
			}
			case 3 -> {
				System.out.print("조회할 부서번호>> ");
				int depid = sc.nextInt();
				EmpView.print(empService.selectByDepart(depid), "특정부서의 직원 조회");
			}
			case 4 -> {
				System.out.print("조회할 JOB>> ");
				String jobid = sc.next();
				EmpView.print(empService.selectByJOB(jobid), "특정JOB인 직원 조회");
			}
			case 5 -> {
				System.out.print("조회할 (부서/직책/입사일/급여)>> ");
				int deptid = sc.nextInt();
				String jobid = sc.next();
				java.sql.Date hdate = DateUtil.getSQLDate(sc.next());  //0000-00-00
				int salary = sc.nextInt();
				EmpView.print(empService.selectByCondition(deptid, jobid, hdate, salary), " (부서/직책/입사일/급여)조건조회");
			}
			case 6 -> {
				EmpDTO emp = insertMenu();
				int result = empService.empInsert(emp);
				EmpView.print(result > 0 ? "입력성공" : "입력실패");
			}
			case 7 -> {
				EmpDTO emp = insertMenu();
				int result = empService.empUpdate(emp);
				EmpView.print(result > 0 ? "수정성공" : "수정실패");
			}
			case 8 -> {
				System.out.print("삭제할 직원번호>> ");
				int empid = sc.nextInt();
				int result = empService.empDelete(empid);
				EmpView.print(result > 0 ? "삭제성공" : "삭제실패");
			}
			case 9 -> {
				System.out.print("조회할 직원번호>> ");
				int empid = sc.nextInt();
				//모든 칼럼이면 DTO, (이름, job, salary)만 가져오기
				Map<String, Object> emp = empService.empInfo(empid);
				EmpView.print(emp);
			}
			case 10 -> {
				System.out.print("조회할 직원번호>> ");
				int empid = sc.nextInt();
				double result = empService.callFunction(empid);
				EmpView.print("직원의 보너스 : " + result);

			}
			default -> {}
			}
		}
		System.out.println("===========END============");
	}

	private static EmpDTO insertMenu() {
		System.out.print("EMPLOYEE_ID>>"); 
		int empid = sc.nextInt();
		System.out.print("FIRST_NAME");
		String fname = sc.next();
		System.out.print("LAST_NAME");
		String lname = sc.next();
		System.out.print("EMAIL");
		String email = sc.next();
		System.out.print("PHONE_NUMBER");
		String phone = sc.next();
		System.out.print("HIRE_DATE");
		java.sql.Date hdate = DateUtil.getSQLDate(sc.next());
		System.out.print("JOB_ID");
		String job_id = sc.next();
		System.out.print("SALARY");
		int sal = sc.nextInt();
		System.out.print("COMMISSION_PCT");
		double comm = sc.nextDouble();
		System.out.print("MANAGER_ID");
		int mid = sc.nextInt();
		System.out.print("DEPARTMENT_ID");
		int deptid = sc.nextInt();
		
		EmpDTO emp = new EmpDTO();
		
		emp.setCommission_pc(comm);
		emp.setDepartment_id(deptid);
		emp.setEmail(email);
		emp.setEmployee_id(empid);
		emp.setFirst_name(fname);
		emp.setHire_date(hdate);
		emp.setJob_id(job_id);
		emp.setLast_name(lname);
		emp.setManager_id(mid);
		emp.setPhone_number(phone);
		emp.setSalary(sal);
		
		
		return emp;

	}

	private static int menuDisplay() {
		System.out.println("=====================");
		System.out.println("1. 모든 직원 조회");
		System.out.println("2. 특정 직원 조회");
		System.out.println("3. 특정부서의 직원 조회");
		System.out.println("4. 특정JOB인 직원 조회");
		System.out.println("5. 조건조회(부서/직책/입사일/급여)");
		System.out.println("6. 직원입력");
		System.out.println("7. 직원수정");
		System.out.println("8. 직원삭제");
		System.out.println("9. Procedure호출 (직원번호IN/정보OUT");
		System.out.println("10. function호출 (f_bonus)");
		System.out.println("0. 종료");
		System.out.print("작업선택 >");
		int job = sc.nextInt();
		System.out.println("=====================");
		
		return job;
	}
}
