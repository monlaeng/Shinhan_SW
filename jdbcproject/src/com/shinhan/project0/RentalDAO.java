package com.shinhan.project0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.shinhan.util.DBUtil;

public class RentalDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	
	static int custid = 0;
	static String result = "";

	
	public String rent(int prod, String phone) {
		conn = DBUtil.dbConnection();
		


		//1. product_hj에서 물품 개수 확인
		//1-1. 있으면 1 감소
		//1-2. 없으면 종료
		//2. customer_hj에 일치하는 전화번호 있는지 확인
		//2-1. 있으면 고객 리스트의 보증금액 & 사용금액만 update
		//2-2. 없으면 고객 리스트 새로 insert
		//3.rental_hj에 새로 insert
		boolean isrentable = isRentable(prod);	//남은 개수 체크하는 함수
		boolean iscustomer = isCustomer(phone);	//고객 리스트에 이미 있는지 확인하는 함수
		
		if (isrentable) {
			if (!iscustomer) {
				if (prod > 2) {
					return "선택하신 물품은 텐트 또는 돗자리를 먼저 대여 후 이용가능한 물품입니다.";
				} else {
					//고객리스트 추가
					insertCustomer(prod,phone);
					//렌탈리스트 추가
					//count 감소
				}
			} else {
				//렌탈리스트 추가
				//count 감소
				insertRent(prod);
			}
		}

		
		
		return result;
		
	}
	
	private void insertCustomer(int prod, String phone) {
		int result = 0;
		Scanner sc = new Scanner(System.in);
		String sql1 = "select product_price from product_hj where product_id =" + prod;
		String sql2 = "select account_id from account_hj where to_char(account_date, 'yyyy-mm-dd')=to_char(sysdate, 'yyyy-mm-dd')\r\n";
		String sql3 = "insert into Customer_hj values(seqC.nextval, ?, ?, ?, ?, TO_TIMESTAMP(sysdate, 'YYYY-MM-DD HH24:MI:SS'), ?); ";
		conn = DBUtil.dbConnection();
		
		System.out.print("이름을 입력하세요 >");
		String name = sc.next();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql1);
			pst = conn.prepareStatement(sql3);
			while(rs.next()) {
				int price = rs.getInt(1);
				System.out.println(price);
				pst.setString(1, name);
				pst.setString(2, phone);
				pst.setInt(3,5000);
				pst.setInt(4, price);
				rs = st.executeQuery(sql2);
				while(rs.next()) {
					int account_id = rs.getInt(1);
					pst.setInt(5, account_id);
					System.out.println(account_id);
				}
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

	private void insertRent(int prod) {
		
	}

	//customer_hj에 존재하는 고객인지 체크, 있을 경우 static으로 고객id까지 저장
	private boolean isCustomer(String phone) {
		boolean istrue = false;
		String sql = "select customer_id from customer_hj where phone = ?";
		conn = DBUtil.dbConnection();

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, phone);
			rs = pst.executeQuery();
			if(rs.next()) {
				istrue = true;
				custid = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnect(conn, pst, rs);
		}
		

		return istrue;
	}

	//product_hj에 해당 물품 count 남아있는지 체크
	private boolean isRentable(int prod) {
		boolean istrue = false;
		String sql = "select product_count from product_hj where product_id=?";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, prod);
			rs = pst.executeQuery();
			while(rs.next()) {
				int cnt = rs.getInt(1);
				if(cnt <= 0) {
					result = "해당 물품의 재고가 없습니다.";
				} else {
					istrue = true;
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

	private boolean isMain(String phone) {
		// TODO Auto-generated method stub
		return false;
	}
}
