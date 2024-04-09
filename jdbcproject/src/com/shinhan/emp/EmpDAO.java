package com.shinhan.emp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shinhan.util.DBUtil;

//DAO(Data Access하는 비지니스 로직을 처리하는 Object)
public class EmpDAO {
	
	Connection conn;
	Statement st;
	PreparedStatement pst;	//Statement를 상속받음, 바인딩 변수(?) 지원,
	ResultSet rs;
	
	//8. 삭제 (Delete)
			public int empDelete(int empid) {
				int result = 0;
				String sql = "delete from employees "
						+"where EMPLOYEE_ID = ?";
					
				conn = DBUtil.dbConnection();	//setAutoCommit (true 되어있음)
				
				try {
					pst = conn.prepareStatement(sql);
					pst.setInt(1, empid);
					result = pst.executeUpdate(); //DML 문장은 executeUpdate, Select 문은 executQuery
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					DBUtil.dbDisConnect(conn, pst, rs);
				}
				return result;

			}

	
	
	//7. 수정 (Update)
		public int empUpdate(EmpDTO emp) {
			int result = 0;
			String sql = "update employees "
					+ "set FIRST_NAME = ?,"
					+ " LAST_NAME = ?,"
					+ " EMAIL = ?,"
					+ " PHONE_NUMBER = ?,"
					+ " HIRE_DATE = ?,"
					+ " JOB_ID = ?,"
					+ " SALARY = ?,"
					+ " COMMISSION_PCT = ?,"
					+ " MANAGER_ID = ?,"
					+ " DEPARTMENT_ID = ?"
					+ " where employee_id=?";
			conn = DBUtil.dbConnection();	//setAutoCommit (true 되어있음)
			
			try {
				pst = conn.prepareStatement(sql);
				pst.setInt(11, emp.getEmployee_id());
				pst.setString(1, emp.getFirst_name());
				pst.setString(2, emp.getLast_name());
				pst.setString(3, emp.getEmail());
				pst.setString(4, emp.getPhone_number());
				pst.setDate(5, emp.getHire_date());
				pst.setString(6, emp.getJob_id());
				pst.setInt(7, emp.getSalary());
				pst.setDouble(8, emp.getCommission_pc());
				pst.setInt(9, emp.getManager_id());
				pst.setInt(10, emp.getDepartment_id());
				result = pst.executeUpdate(); //DML 문장은 executeUpdate, Select 문은 executQuery
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBUtil.dbDisConnect(conn, pst, rs);
			}
			return result;

		}

		
	//6. 입력 (Insert)
	public int empInsert(EmpDTO emp) {
		int result = 0;
		String sql = "insert into employees values(?,?,?,?,?,?,?,?,?,?,?)";
		conn = DBUtil.dbConnection();	//setAutoCommit (true 되어있음)
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, emp.getEmployee_id());
			pst.setString(2, emp.getFirst_name());
			pst.setString(3, emp.getLast_name());
			pst.setString(4, emp.getEmail());
			pst.setString(5, emp.getPhone_number());
			pst.setDate(6, emp.getHire_date());
			pst.setString(7, emp.getJob_id());
			pst.setInt(8, emp.getSalary());
			pst.setDouble(9, emp.getCommission_pc());
			pst.setInt(10, emp.getManager_id());
			pst.setInt(11, emp.getDepartment_id());
			result = pst.executeUpdate(); //DML 문장은 executeUpdate, Select 문은 executQuery
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnect(conn, pst, rs);
		}
		return result;

	}
	
	//5.다양한 조건으로 조회하기
	//부서별(=), 직책별(=), 입사일별 (>=), 급여(>=)
	public List<EmpDTO> selectByCondition(int deptid, String jobid, Date hdate, int salary) {
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();		
		String sql = "select * \r\n"
				+ "from employees \r\n"
				+ "where department_id = ?"
				+ " and job_id = ?"
				+ " and hire_date >= ?"
				+ " and salary >= ?";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, deptid); 	//첫 번째 ?에 jobid를 넣어라
			pst.setString(2, jobid); 	//첫 번째 ?에 jobid를 넣어라
			pst.setDate(3, hdate); 	//첫 번째 ?에 jobid를 넣어라
			pst.setInt(4, salary); 	//첫 번째 ?에 jobid를 넣어라
			rs = pst.executeQuery();
			while(rs.next()) {
				EmpDTO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisConnect(conn, pst, rs);
		}
		return emplist;
	}
	
	
	//4-2.특정JOB인 직원 조회하기(효율적)
	public List<EmpDTO> selectByJOB2(String jobid) {
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();		
		String sql = "select * from employees where job_id like ? || '%'";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, jobid); 	//첫 번째 ?에 jobid를 넣어라
			rs = pst.executeQuery();
			while(rs.next()) {
				EmpDTO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisConnect(conn, pst, rs);
		}
		return emplist;
	}
	
	//4.특정JOB인 직원 조회하기(비효율)
	public List<EmpDTO> selectByJOB(String jobid) {
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();		
		String sql = "select * from employees where job_id = " + "'" + jobid + "'";
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				EmpDTO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisConnect(conn, st, rs);
		}
		return emplist;
	}
	
	//3.특정부서의 직원 조회하기
	public List<EmpDTO> selectByDepart(int depid) {
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();		
		String sql = "select * from employees where department_id = ?" ;
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, depid);
			rs = pst.executeQuery();
			while(rs.next()) {
				EmpDTO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisConnect(conn, pst, rs);
		}
		return emplist;
	}
	
	//2. 특정직원의 상세보기
	public EmpDTO selectById(int empid) {
		EmpDTO emp = null;
		String sql = "select * from employees where employee_id = " + empid;
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				emp = makeEmp(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisConnect(conn, st, rs);
		}
		return emp;
	}
	
	//1. 직원 모두 조회
	public List<EmpDTO> selectAll() {
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();
		String sql = "select * from employees";
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				EmpDTO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnect(conn, st, rs);
		}
		return emplist;
	}

	private EmpDTO makeEmp(ResultSet rs) throws SQLException {
		EmpDTO emp = new EmpDTO();
		emp.setCommission_pc(rs.getDouble("commission_pct"));
		emp.setDepartment_id(rs.getInt("department_id"));
		emp.setEmail(rs.getString("email"));
		emp.setEmployee_id(rs.getInt("employee_id"));
		emp.setFirst_name(rs.getString("first_name"));
		emp.setHire_date(rs.getDate("hire_date"));
		emp.setJob_id(rs.getString("job_id"));
		emp.setLast_name(rs.getString("last_name"));
		emp.setManager_id(rs.getInt("manager_id"));
		emp.setPhone_number(rs.getString("phone_number"));
		emp.setSalary(rs.getInt("salary"));
		
		
		return emp;
	}


	//직원번호를 입력 받아서 직원정보(이름, 직책, 급여)를 return
	public Map<String, Object> empInfo(int empid) {
		Map<String, Object> empMap = new HashMap<>();
		String fname = null, job = null;
		int salary = 0;
		String sql = " {call sp_empInfo(?,?,?,?)} ";
		CallableStatement cstmt = null;
		conn = DBUtil.dbConnection();
		try {
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, empid);
			cstmt.registerOutParameter(2, Types.VARCHAR);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			cstmt.registerOutParameter(4, Types.INTEGER);
			boolean result = cstmt.execute();
			fname = cstmt.getString(2);
			job = cstmt.getString(3);
			salary = cstmt.getInt(4);
			empMap.put("fname", fname);
			empMap.put("job", job);
			empMap.put("salary", salary);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnect(conn, cstmt, rs);
		}
		
		return empMap;
	}
	
	//10. 직원번호가 들어오면 직운의 보너스를  호출한디.
	public double callFunction (int empid) {
		double bonus = 0;
		String sql = "select f_bonus(?) from dual";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, empid);
			rs = pst.executeQuery();
			if(rs.next()) {
				bonus = rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnect(conn, pst, rs);
		}
		
		return bonus;
	}
	
	
	
	//특정 직원 1명 조회
	
	//특정 부서의 근무하는 직원들
	
	//입력
	//수정
	//삭제
	
}
