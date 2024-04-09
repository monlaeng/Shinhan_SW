package com.shinhan.day14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//0. jdbc driver를 class path 추가
		//1. jdbc 드라이버를 load
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("1. oracle driver load 성공");
		//2. DB 연결
		String url="jdbc:oracle:thin:@localhost:1521:xe", usrid="hr", password="hr";
		Connection conn = DriverManager.getConnection(url, usrid, password);
		System.out.println("2.DB 연결 성공");
		String sql = "select first_name || ' ' || last_name as 이름, salary as 급여, department_id as 부서id\r\n"
				+ "from employees "
				+ "where salary >= 15000";
		//3. Statement : 자바와 DB의 대화통로
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {	//data가 있는 동안 반복
			//DB는 1부터 읽는다. 0번째가 없음
			String fname = rs.getString(1);
			int salary = rs.getInt(2);
			int deptid= rs.getInt(3);
			System.out.printf("%-10s\t%d\t%d\n", fname, salary, deptid);
		}
		rs.close();
		st.close();
		conn.close();
	}
}
