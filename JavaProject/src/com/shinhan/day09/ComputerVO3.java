package com.shinhan.day09;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

//class : 틀 (template), object를 만들기 위해
//object : instance(실체)

//VO (Value Object : data 저장(field 여러 개), C언어의 structor(스트럭쳐) 비슷
//DTO(Data Transfer Object) : data 전송목적
//JavaBeans 기술 : default 생성자가 반드시 있어야한다.
//@ToString
//@EqualsAndHashCode
//@Getter@Setter
@AllArgsConstructor
//@NoArgsConstructor
@Data
public class ComputerVO3 {

	
	@NonNull String model;
	int price;
	String company;	

}
