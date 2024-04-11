package com.shinhan.project0;

import java.util.List;

public class ShowService {
	ShowDAO showDAO = new ShowDAO();
	
	public List<ProductDTO> showProd() {
		return showDAO.showProd();
	}
	
	public int showAccount() {
		return showDAO.showAccount();
	}
}
