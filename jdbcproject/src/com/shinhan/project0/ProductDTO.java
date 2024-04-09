package com.shinhan.project0;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class ProductDTO {
	private int prod_id;
	private String prod_name;
	private int prod_count;
	private int prod_price;
}
