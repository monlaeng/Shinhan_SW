package com.shinhan.day10;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//DTO(Data Transfer Object)
//VO(Value Object)
//JavaBeans(JspServlet, Spring, Mybatic) : NoArgsConstructor 반드시 필요, getter/setter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Product<K, V>{
	private K kind;
	private V model;
	
	
}
