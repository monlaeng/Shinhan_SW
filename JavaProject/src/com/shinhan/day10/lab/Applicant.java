package com.shinhan.day10.lab;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Applicant<T> {

	private T kind;
	
}
