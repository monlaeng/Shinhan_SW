package com.shinhan.day10.lab;

public class Container<T> {

	T data;
	
	void set(T data) {
		this.data = data;
	}
	T get() {
		return data;
	}
	
}
