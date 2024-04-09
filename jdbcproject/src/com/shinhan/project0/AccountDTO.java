package com.shinhan.project0;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class AccountDTO {
	private int  account_id;
	private int proceeds;
	private Date account_date;
}
