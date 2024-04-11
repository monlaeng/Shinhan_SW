package com.shinhan.project0;

import java.util.List;

public class View {

	public static void print(List<ProductDTO> prodlist, String title) {
		
		System.out.printf("=================%s=================\n",title);
		prodlist.stream().forEach(prod->{
		if(prod == null) {
			System.out.println("존재하지 않는 리스트입니다.");
		} else {
			System.out.println("품목번호 : " + prod.getProduct_id());
			System.out.println("품목이름 : " + prod.getProduct_name());
			System.out.println("개수 : " + prod.getProduct_count());
			System.out.println("가격 : " + prod.getProduct_price());
			System.out.println("-------------------------------------");

		}});
	}
}
