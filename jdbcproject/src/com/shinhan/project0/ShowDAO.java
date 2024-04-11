package com.shinhan.project0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.util.DBUtil;

public class ShowDAO {
	
	Connection conn;
	Statement st;
	PreparedStatement pst;	
	ResultSet rs;
	
	//1. 물품 리스트
	public List<ProductDTO> showProd() {
		List<ProductDTO> prodlist = new ArrayList<ProductDTO>();
		String sql = "select * from product_hj";
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				ProductDTO prod = makeProd(rs);
				prodlist.add(prod);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnect(conn, st, rs);
		}
		
		
		return prodlist;
		
	}
	
	//계좌 정산금 확인
	public int showAccount() {
		int result = 0;
		List<AccountDTO> acclist = new ArrayList<AccountDTO>();
		String sql = "select proceeds from account_hj where to_char(account_date, 'yyyy-mm-dd')=to_char(sysdate, 'yyyy-mm-dd')\r\n";
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnect(conn, st, rs);
		}
		
		
		return result;
		
	}
	
	//makeProd
	private ProductDTO makeProd(ResultSet rs) throws SQLException {
		ProductDTO prod = new ProductDTO();
		prod.setProduct_id(rs.getInt("product_id"));
		prod.setProduct_name(rs.getString("product_name"));
		prod.setProduct_count(rs.getInt("product_count"));
		prod.setProduct_price(rs.getInt("product_price"));
		return prod;
	}
}
