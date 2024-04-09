package com.shinhan.project0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.shinhan.util.DBUtil;

public class TableDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	
	//테이블 4개 생성
	public int createTable() {
		int result = 1;
		conn = DBUtil.dbConnection();

		//제출할 때는 지워야 하는 코드
		String drop1 = "drop table Rental_hj";
		String drop2 = "drop table Customer_hj";
		String drop3 = "drop table Account_hj";
		String drop4 = "drop table Product_hj";
		//제출할 때는 지워야 하는 코드

		String prodSql = "CREATE TABLE Product_hj(\r\n"
				+ "    product_id number PRIMARY KEY,\r\n"
				+ "    product_name varchar2(20),\r\n"
				+ "    product_count number, \r\n"
				+ "    product_price number\r\n"
				+ "    )" ;
		String accSql = "create table Account_hj (\r\n"
				+ "    account_id number PRIMARY KEY,\r\n"
				+ "    proceeds number,\r\n"
				+ "    account_date Date\r\n"
				+ "    )";
		String custSql = "create table Customer_hj (\r\n"
				+ "    customer_id number PRIMARY KEY,\r\n"
				+ "    customer_name varchar2(30),\r\n"
				+ "    phone varchar2(30),\r\n"
				+ "    deposit number,\r\n"
				+ "    total_price number,\r\n"
				+ "    used_time date,\r\n"
				+ "    account_id number,\r\n"
				+ "    foreign key(account_id) REFERENCES Account_hj(account_id)\r\n"
				+ "    \r\n"
				+ ")";
		String rentSql = "create table Rental_hj (\r\n"
				+ "    rental_id number PRIMARY KEY,\r\n"
				+ "    customer_id number,\r\n"
				+ "    product_id number,\r\n"
				+ "    foreign key(customer_id) REFERENCES Customer_hj(customer_id),\r\n"
				+ "    foreign key(product_id) REFERENCES Product_hj(product_id)\r\n"
				+ ")";
		

		try {
			st = conn.createStatement();
			result= st.executeUpdate(drop1);
			result= st.executeUpdate(drop2);
			result= st.executeUpdate(drop3);
			result= st.executeUpdate(drop4);
			result = st.executeUpdate(prodSql);
			result = st.executeUpdate(accSql);
			result = st.executeUpdate(custSql);
			result = st.executeUpdate(rentSql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnect(conn, st, rs);
			;
		}

		return result;
	}
	// sequence 초기화 및 생성
	public int setSeq() {
		int result = 0;
		conn = DBUtil.dbConnection();
		String[] seq = sequenSql();
		
		try {
			st = conn.createStatement();
			for (String str : seq) { 
				result = st.executeUpdate(str);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnect(conn, st, rs);
		}
		return result;
	}
	
	//account 초기 data input
	public boolean setAccount() {
		boolean result = false;
		conn = DBUtil.dbConnection();
		String[] accsql = accSql();
		try {
			st = conn.createStatement();
			for(String str : accsql) {		
				result = st.execute(str);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisConnect(conn, st, rs);
		}
		return result;
	}
	
	//product 초기 data input
	public int setProduct() { 
		int result = 0;
		conn = DBUtil.dbConnection();	
		String[] prodsql = prodSql();

		try {
			st = conn.createStatement();
			for(String str : prodsql) {		
				result = st.executeUpdate(str);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnect(conn, st, rs);
		}

		return result;
	}
	
	//Customer 초기 data input
	public int setCustomer() {
		int result = 0;
		conn = DBUtil.dbConnection();
		String[] custsql = custSql();
		String getId = "select account_id from account_hj where to_char(account_date, 'yyyy-mm-dd')=to_char(sysdate, 'yyyy-mm-dd')\r\n";

		try {		
			st=conn.createStatement();
			rs = st.executeQuery(getId);
			if(rs.next()) {
				int id = rs.getInt(1);
				for(String str : custsql) {
					pst = conn.prepareStatement(str);
					pst.setInt(1, id);
					result = pst.executeUpdate();
				}
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnect(conn, pst, rs);
			DBUtil.dbDisConnect(conn, st, rs);
		}
		return result;
	}
	
	public int setRental() {
		int result = 0;
		conn = DBUtil.dbConnection();
		String[] rentsql = rentSql();
		
		try {
			st = conn.createStatement();
			for(String str : rentsql) {		
				result = st.executeUpdate(str);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnect(conn, st, rs);
		}

		return result;
		
	}
	
	//Customer sql문
	private String[] custSql() {
		String[] sql = {
				"insert into Customer_hj values(seqC.nextval, '강아지','010-0000-0000', 5000, 6000, TO_TIMESTAMP('2024-04-09 10:30:00', 'YYYY-MM-DD HH24:MI:SS'), ?)",
				"insert into Customer_hj values(seqC.nextval, '고양이','010-1111-1111', 15000, 9000, TO_TIMESTAMP('2024-04-09 11:20:00', 'YYYY-MM-DD HH24:MI:SS'), ?)",
				"insert into Customer_hj values(seqC.nextval, '햄스터','010-2222-2222', 10000, 6000, TO_TIMESTAMP('2024-04-09 14:25:00', 'YYYY-MM-DD HH24:MI:SS'), ?)"
		};
		
		return sql;
	}
	
	//Sequence sql문
	private String[] sequenSql() { 
		String[] seq = {
				"CREATE SEQUENCE seqA START WITH 1 INCREMENT BY 1 MAXVALUE 100 CYCLE NOCACHE",
				"CREATE SEQUENCE seqB START WITH 1 INCREMENT BY 1 MAXVALUE 100 CYCLE NOCACHE",
				"CREATE SEQUENCE seqC START WITH 1 INCREMENT BY 1 MAXVALUE 100 CYCLE NOCACHE",
				"CREATE SEQUENCE seqD START WITH 1 INCREMENT BY 1 MAXVALUE 100 CYCLE NOCACHE"
		};
		return seq;
	}

	//Account sql문
	private String[] accSql() {
		String[] sql = {
				"insert into Account_hj values(seqA.nextval, 200000, '2024-04-01')",
				"insert into Account_hj values(seqA.nextval, 300000, '2024-04-03')",
				"insert into Account_hj values(seqA.nextval, 150000, '2024-04-04')",
				"insert into Account_hj values(seqA.nextval, 210000, '2024-04-07')",
				"insert into Account_hj values(seqA.nextval, 330000, '2024-04-08')",
				"insert into Account_hj values(seqA.nextval, 0, sysdate)"
		};
		return sql;
	}
	
	//Product sql문
	private String[] prodSql() {
		String[] sql = {
				"insert into Product_hj values(seqB.nextval, '돗자리', 100, 4000)",
				"insert into Product_hj values(seqB.nextval, '텐트', 50, 6000)",
				"insert into Product_hj values(seqB.nextval, '담요', 100, 1000)",
				"insert into Product_hj values(seqB.nextval, '테이블', 80, 2000)",
				"insert into Product_hj values(seqB.nextval, '스피커', 80, 2000)",
				"insert into Product_hj values(seqB.nextval, '무드등', 50, 1000)"
		};
		
		return sql;
	}
	
	//Rental sql문
	private String[] rentSql() {
		String[] sql = {
				"insert into Rental_hj values(seqD.nextval, 1,2)",
				"insert into Rental_hj values(seqD.nextval, 2,2)",
				"insert into Rental_hj values(seqD.nextval, 3,1)",
				"insert into Rental_hj values(seqD.nextval, 2,3)",
				"insert into Rental_hj values(seqD.nextval, 2,4)",
				"insert into Rental_hj values(seqD.nextval, 3,5)"
		};
		
		return sql;
	}

} 
