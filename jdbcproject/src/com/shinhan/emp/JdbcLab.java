package com.shinhan.emp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcLab {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		boolean isStop = false;
		
		while(!isStop) {
			int selectJob = menu();
			switch(selectJob) {
			case 1 -> {

				String sql = "select salary, hire_date" 
						+ " from employees" 
						+ " where first_name = initcap('adam')";
				method1(sql);
			}
			case 2 -> {
				String sql ="select *\r\n"
						+ "from countries\r\n"
						+ "where lower(country_name) = 'united states of america'";
				method2(sql);
			}
			case 3 -> {
				String sql ="select first_name || '의 입사일은 ' || hire_date || ' 이고, 급여는 ' || salary || ' 입니다.' \r\n"
						+ "from employees";
				method3(sql);
			}
			case 4 -> {
				String sql ="select first_name, salary, hire_date\r\n"
						+ "from employees\r\n"
						+ "where length(first_name) <= ";
				method4(sql);
			}
			case 5 -> {
				String sql ="select first_name, hire_date"
						+ " from employees\r\n"
						+ "where to_char(hire_date, 'yyyy') = ";
				method5(sql);
			}
			case 6 -> {
				String sql ="select first_name, hire_date,"
						+ "trunc(months_between(sysdate, hire_date)/12)\r\n"
						+ "from employees\r\n"
						+ "where months_between(sysdate, hire_date)/12 >= ";
				method6(sql);
			}
			case 7 -> {
				isStop = true;
			}
			default -> {
				System.out.println("입력한 작업은 지원되지 않습니다. 다시 선택하세요.");
			}
			}
		}
		System.out.println("====시스템 종료====");
	}
	
	private static void method6(String sql) {
		Connection conn = dbConnection();
		try {
			Statement st = conn.createStatement();
			
			System.out.print("근무년수 몇 년 이상? >> ");
			int year = sc.nextInt();
			ResultSet rs = st.executeQuery(sql + year);
			
			while(rs.next()) {
				String name = rs.getString(1);
				Date date = rs.getDate(2);
				int work = rs.getInt(3);
				System.out.println(name + " : " + date + " : " + work + "년");
				
			}
			dbDisConnect(conn, st, rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}
	
	private static void method5(String sql) {
		Connection conn = dbConnection();
		try {
			Statement st = conn.createStatement();
			
			System.out.print("조회년도 입력 >> ");
			int year = sc.nextInt();
			ResultSet rs = st.executeQuery(sql + year);
			
			while(rs.next()) {
				String name = rs.getString(1);
				Date date = rs.getDate(2);
				System.out.println(name + " : " + date);
				
			}
			dbDisConnect(conn, st, rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}
	
	private static void method4(String sql) {
		Connection conn = dbConnection();
		try {
			Statement st = conn.createStatement();
			
			System.out.print("이름이 몇 글자 이하인지 입력 >>");
			int su = sc.nextInt();
			ResultSet rs = st.executeQuery(sql + su);
			int i = 0;
			while(rs.next()) {
				i++;
				String name = rs.getString(1);
				int salary = rs.getInt(2);
				Date date = rs.getDate(3);
				System.out.println(i + "==>" + name + "\t" + salary + "\t" + date);
				
			}
			dbDisConnect(conn, st, rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}
	
	private static void method3(String sql) {
		Connection conn = dbConnection();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			int i = 0;
			while(rs.next()) {
				i++;
				String result = rs.getString(1);
				System.out.println(i + "==>" + result);
				
			}
			dbDisConnect(conn, st, rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}


	private static void method2(String sql) {
		Connection conn = dbConnection();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String country_id = rs.getString(1);
				String country_name = rs.getString("country_name");
				int regionId = rs.getInt("region_id");
				System.out.println(country_id + ":" + country_name + ":" + regionId );
				
			}
			dbDisConnect(conn, st, rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}


	private static void method1(String sql) {
		Connection conn = dbConnection();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int sal = rs.getInt(1);
				Date hdate = rs.getDate(2);
				System.out.println(sal + "\t" + hdate);
				
			}
			dbDisConnect(conn, st, rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}

	private static void dbDisConnect(Connection conn, Statement st, ResultSet rs) throws SQLException {
		rs.close();
		st.close();
		conn.close();
		System.out.println("3. 실행 후 DB 해제");
	}

	private static Connection dbConnection() {
		//1.JDBC Driver load
		//2.Connection 생성
		//IP => 192.168.0.39 localhost 127.0.0.1 ...
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String userid="hr";
		String password="hr";

		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1.JDBC Driver load 성공");
			conn = DriverManager.getConnection(url, userid, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
	}

	private static int menu() {
		System.out.println("========================================================");
		System.out.println("1.INITCAP 2.lower 3.concat 4.length ");
		System.out.println("5.to_char 6.months_between 7.END");
		System.out.print("작업을 선택 > ");
		int job = sc.nextInt();
		System.out.println("========================================================");
	
		return job;
	}

}
