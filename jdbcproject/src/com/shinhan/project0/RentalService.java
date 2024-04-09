package com.shinhan.project0;

public class RentalService {
	RentalDAO rentDAO = new RentalDAO();
	
	public String rent(int prod, String phone) {
		return rentDAO.rent(prod, phone);
	}
}
