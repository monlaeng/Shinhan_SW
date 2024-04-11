package com.shinhan.project0;

public class ReturnService {
	ReturnDAO returnDAO = new ReturnDAO();
	
	public String returnProd(String phone) {
		return returnDAO.returnProd(phone); 
	}
}
