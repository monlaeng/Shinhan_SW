package com.shinhan.project0;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class CustomerDTO {

	private int customer_id;
	private String customer_name;
	private String phone;
	private int deposit;
	private int total_price;
	private Date used_date;
	private int account_id;
}
