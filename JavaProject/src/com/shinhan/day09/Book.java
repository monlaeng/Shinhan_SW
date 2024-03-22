package com.shinhan.day09;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//JavaBeans 기술 규격 : field는 private, getter/setter, default 생성자
//DTO(Data Transfer Object) : data를 전송하기 위해 만듦
//VO : 

@ToString(exclude = "price")
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	String title;
	int price;
	String author;

	
	
}
