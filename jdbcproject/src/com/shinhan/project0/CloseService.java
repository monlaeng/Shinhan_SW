package com.shinhan.project0;

public class CloseService {
	
	CloseDAO closeDAO = new CloseDAO();

	public String closeAll() {
		return closeDAO.closeAll();
	}
}
