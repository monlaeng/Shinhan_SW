package com.shinhan.project0;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class ProductDTO {
	private int product_id;
	private String product_name;
	private int product_count;
	private int product_price;
}
