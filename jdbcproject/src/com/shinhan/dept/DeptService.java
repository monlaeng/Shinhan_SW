package com.shinhan.dept;

import java.util.List;

public class DeptService {
	DeptDAO deptDAO = new DeptDAO();
	
	public int deptUpdate(DeptDTO dept) {
		return deptDAO.deptUpdate(dept);
	}

	public int deptInsert(DeptDTO dept) { 
		return deptDAO.deptInsert(dept);
	}
	
	public DeptDTO selectDept(int department_id) {
		return deptDAO.selectDept(department_id);
	}
	
	public List<DeptDTO> selectAll() {
		return deptDAO.selectAll(); 
	}
}
