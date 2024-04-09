package com.shinhan.emp;


import java.util.Date;
import java.util.List;
import java.util.Map;

//Controller -> Service ->DAO
//			 <-			<-
//Service : 비즈니스 로직을 수행한다.
public class EmpService {
		
	EmpDAO empDAO = new EmpDAO();
	
	//8. 삭제 (Delete)
	public int empDelete(int empid) {
		return empDAO.empDelete(empid);
	}
	
	//7. 수정 (Update)
	public int empUpdate(EmpDTO emp) {
		return empDAO.empUpdate(emp);
	}
	
	//6. 입력 (Insert)
	public int empInsert(EmpDTO emp) {
		return empDAO.empInsert(emp);
	}
	
	//5.다양한 조건으로 조회하기
	//부서별(=), 직책별(=), 입사일별 (>=), 급여(>=)
	public List<EmpDTO> selectByCondition(int deptid, String jobid, java.sql.Date hdate, int salary) {
		return empDAO.selectByCondition(deptid, jobid, hdate, salary);
	}
	
	
	//4. 특정JOB인 직원 조회
	public List<EmpDTO> selectByJOB(String jobid) {
		
		return empDAO.selectByJOB2(jobid);
	}
	
	//3. 특정부서 직원 조회
	public List<EmpDTO> selectByDepart(int depid) {
		
		return empDAO.selectByDepart(depid);
	}
	
	//2. 특정직원 상세보기
	public EmpDTO selectById(int empid) {
		
		return empDAO.selectById(empid);
	}
	

	//1. 직원 모두 조회
	public List<EmpDTO> selectAll() {
		
		return empDAO.selectAll();
	
	}
	
	//9. 직원 번호를 이용해서 직원의 이름과 직책과 급여를 조회한다.
	public Map<String, Object> empInfo(int empid) {

		return empDAO.empInfo(empid);
	}
	
	//10. 직원번호가 들어오면 직운의 보너스를  호출한디.
	public double callFunction (int empid) {
		return empDAO.callFunction(empid);
	}
}
