package com.shinhan.project0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.shinhan.util.DBUtil;

public class CloseDAO {
	//마감
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	
	
	
	
	public String closeAll() {
		int result = 0;
		conn = DBUtil.dbConnection();
		String sql = "select sum(deposit) + sum(total_price)\r\n"
				+ "from customer_hj";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				result = rs.getInt(1);
			}
			addFee(result);
			incProd();
			deleteAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnect(conn, st, rs);
		}
		
		
		return "오늘 영업 마감합니다. ";
	}
	
	//상인에게 물품 반납(물품 개수 증가)
	private void incProd() {
		conn = DBUtil.dbConnection();
		String sql = "select product_id, count(*)\r\n"
				+ "from rental_hj\r\n"
				+ " group by product_id";
		String sql2 = "update product_hj\r\n" 
				+ "set product_count = product_count + ? "
				+ "where product_id= ?";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				int prod_id = rs.getInt(1);
				int prod_cnt = rs.getInt(2);
				
				pst = conn.prepareStatement(sql2);
				pst.setInt(2, prod_id);
				pst.setInt(1, prod_cnt);
				pst.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnect(conn, pst, rs);
			DBUtil.dbDisConnect(conn, st, rs);
		}
		
		
	}
	
	private void deleteAll() {
		conn = DBUtil.dbConnection();
		String sql = "delete from rental_hj";
		String sql2 = "delete from customer_hj";
		
		try {
			st = conn.createStatement();
			st.executeUpdate(sql);
			st.executeUpdate(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnect(conn, st, rs);
		}
				
	}

	//상인 가계부에 정산금 추가
	private void addFee(int price) {
		int result = 0;
		conn = DBUtil.dbConnection();
		String sql = "update account_hj\r\n"
				+ "set proceeds = proceeds + " + price
				+ "where to_char(account_date, 'yyyy-mm-dd')=to_char(sysdate, 'yyyy-mm-dd')";

		try {		
			st=conn.createStatement();
			result = st.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnect(conn, st, rs);
		}
	}
}
