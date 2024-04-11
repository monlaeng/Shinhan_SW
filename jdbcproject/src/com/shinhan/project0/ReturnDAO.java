package com.shinhan.project0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.shinhan.util.DBUtil;

public class ReturnDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	
	static int custid = 0;
	static String result = "";
	
	public String returnProd(String phone) {
		//고객리스트에 phone과 일치하는 고객 있는지 확인
		boolean iscustomer = isCustomer(phone); 
		if(!iscustomer) {
			return "대여하신 물품이 없습니다.";
		} 
		//상인 물품 돌려주기
		incProd();
		//반납시간에 따른 사용금액과 보증금액 최종 정산금액
		int price = calFee();
		//대여리스트&고객리스트에서 해당 고객 대여기록 전부 삭제
		deleteInfo();
		//상인 가계부에 정산금액 callFee 추가
		addFee(price);
		return result;
	}

	//상인에게 물품 반납(물품 개수 증가)
	private void incProd() {
		int result = 0;
		conn = DBUtil.dbConnection();
		String sql = "select product_id, count(*)\r\n"
				+ "from rental_hj\r\n"
				+ "where customer_id =" + custid
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
				result = pst.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnect(conn, pst, rs);
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

	//반납한 고객 정보 고객리스트&대여리스트에서 삭제
	private void deleteInfo() {
		int result = 0;
		conn = DBUtil.dbConnection();
		String sql = "delete from rental_hj where customer_id = " + custid;
		String sql2 = "delete from customer_hj where customer_id = " + custid;
		
		try {
			st = conn.createStatement();
			result = st.executeUpdate(sql);
			result = st.executeUpdate(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnect(conn, st, rs);
		}
	}

	//연체시간 계산하여 보증금애서 차감 후 정산금에 추가
	private int calFee() {
		conn = DBUtil.dbConnection();
		int used_time = 0;
		int total_price = 0 , deposit = 0;
		String sql = "select to_number(round((sysdate - used_time ) * 24 *60 ))\r\n"
				+ "from customer_hj\r\n"
				+ "where customer_id =" + custid;
		String sql2 = "select total_price, deposit\r\n"
				+ "from customer_hj "
				+ "where customer_id =" + custid;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql2);
			while(rs.next()) {
				total_price = rs.getInt(1);
				deposit = rs.getInt(2);
			}
			rs = st.executeQuery(sql);
			while(rs.next()) {
				used_time = rs.getInt(1);
			}
			result = "총 사용시간 : " + (used_time/60) 
					+ "시간 " + (used_time%60) + "분 \n"
					+ "보증금 " + deposit
					;
			
			
			if(used_time > 180) {
				used_time = (used_time-180) / 3 + 1;
				if(deposit > used_time * 5000) {
					used_time *= 5000;
					total_price += used_time * 5000;
					result += "원에서 " + used_time + "원 차감하여 환급합니다. 감사합니다.";
				} else {
					total_price += deposit;
					result +="원에서 " + deposit + "원 차감하여 환급합니다. 감사합니다.";
				}

			} else {
				result += "원 환급합니다. 감사합니다.";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnect(conn, st, rs);
		}
		return total_price;
	}

	// customer_hj에 존재하는 고객인지 체크, 있을 경우 static으로 고객id까지 저장
	private boolean isCustomer(String phone) {
		boolean istrue = false;
		String sql = "select customer_id from customer_hj where phone = ?";
		String sql2 = "select count(*)+1 from customer_hj";
		conn = DBUtil.dbConnection();

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, phone);
			rs = pst.executeQuery();
			if (rs.next()) {
				istrue = true;
				custid = rs.getInt(1);
			} else {
				st = conn.createStatement();
				rs = st.executeQuery(sql2);
				while (rs.next()) {
					custid = rs.getInt(1);
					System.out.println(custid);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnect(conn, pst, rs);
		}

		return istrue;
	}

}
