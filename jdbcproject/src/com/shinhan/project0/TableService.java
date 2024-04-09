package com.shinhan.project0;

public class TableService {
	TableDAO tableDAO = new TableDAO();

	public int createTable() {
		return tableDAO.createTable();
	}
	
	public int setSeq() {
		return tableDAO.setSeq();
	}
	public int setProduct() {
		return tableDAO.setProduct();
	}
	public boolean setAccount() {
		return tableDAO.setAccount();
	}
	public int setCustomer() {
		return tableDAO.setCustomer();
	}
	public int setRental() {
		return tableDAO.setRental();
	}
}
