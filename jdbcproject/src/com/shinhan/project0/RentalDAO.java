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

		// 1. product_hj에서 물품 개수 확인
		// 1-1. 있으면 1 감소
		// 1-2. 없으면 종료
		// 2. customer_hj에 일치하는 전화번호 있는지 확인
		// 2-1. 있으면 고객 리스트의 보증금액 & 사용금액만 update
		// 2-2. 없으면 고객 리스트 새로 insert
		// 3.rental_hj에 새로 insert
		boolean isrentable = isRentable(prod); // 남은 개수 체크하는 함수
		boolean iscustomer = isCustomer(phone); // 고객 리스트에 이미 있는지 확인하는 함수

		if (isrentable) {
			if (!iscustomer) {
				if (prod > 2) {
					return "선택하신 물품은 텐트 또는 돗자리를 먼저 대여 후 이용가능한 물품입니다.";
				} else {
					// 고객리스트 추가
					insertCustomer(prod, phone);
					// 렌탈리스트 추가
					insertRent(prod);
					// count 감소
					descProd(prod);

				}
			} else {
				// 기존고객 보증금&사용금액 update
				updateCutomer(prod);
				// 렌탈리스트 추가
				insertRent(prod);
				// count 감소
				descProd(prod);
			}
			result = "대여 완료되었습니다.";
		}
		return result;

	}

	private void updateCutomer(int prod) {
		int result = 0;
		conn = DBUtil.dbConnection();
		String sql1 = "update customer_hj\r\n" + "set deposit = deposit + 5000, total_price = total_price + ?\r\n"
				+ "where customer_id= ?";
		String sql2 = "select product_price from product_hj where product_id =" + prod;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql2);
			while (rs.next()) {
				int price = rs.getInt(1);
				pst = conn.prepareStatement(sql1);
				pst.setInt(1, price);
				pst.setInt(2, custid);
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

	private void descProd(int prod) {
		int result = 0;
		conn = DBUtil.dbConnection();
		String sql = "update product_hj \r\n" + "set product_count = product_count-1\r\n" + "where product_id = ?";

		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, prod);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnect(conn, pst, rs);
		}
	}

	private void insertCustomer(int prod, String phone) {
		int result = 0;
		Scanner sc = new Scanner(System.in);
		String sql1 = "select product_price from product_hj where product_id =" + prod;
		String sql2 = "select account_id from account_hj where to_char(account_date, 'yyyy-mm-dd')=to_char(sysdate, 'yyyy-mm-dd')\r\n";
		String sql3 = "insert into Customer_hj values(seqC.nextval, ?, ?, ?, ?, sysdate, ?)";
		conn = DBUtil.dbConnection();

		System.out.print("이름을 입력하세요 >");
		String name = sc.next();

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql1);
			pst = conn.prepareStatement(sql3);
			while (rs.next()) {
				int price = rs.getInt(1);
				pst.setString(1, name);
				pst.setString(2, phone);
				pst.setInt(3, 5000);
				pst.setInt(4, price);
				rs = st.executeQuery(sql2);
				while (rs.next()) {
					int account_id = rs.getInt(1);
					pst.setInt(5, account_id);
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

	private int insertRent(int prod) {
		int result = 0;
		conn = DBUtil.dbConnection();

		String sql = "insert into Rental_hj values(seqD.nextval, ?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, custid);
			pst.setInt(2, prod);
			result = pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnect(conn, pst, rs);
		}

		return result;

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

	// product_hj에 해당 물품 count 남아있는지 체크
	private boolean isRentable(int prod) {
		boolean istrue = false;
		String sql = "select product_count from product_hj where product_id=?";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, prod);
			rs = pst.executeQuery();
			while (rs.next()) {
				int cnt = rs.getInt(1);
				if (cnt <= 0) {
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
