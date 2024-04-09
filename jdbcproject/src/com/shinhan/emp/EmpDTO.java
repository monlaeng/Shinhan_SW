package com.shinhan.emp;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//VO (Value Object)
//DTO(Data Transfer Object)
//JavaBeans 기술에서 이용(Spring, JSP, Mybatis 는 javaBeans 기술을 사용한다.)
@Getter @Setter @ToString
public class EmpDTO {
	private int employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	private Date hire_date;
	private String job_id;
	private int salary;
	private double commission_pc;
	private int manager_id;
	private int department_id;

}
