package com.shinhan.day10;

public class Container<T> {
	T data;
	
	void set(T data) {
		this.data = data;
	}
	
	T get() {
		return data;
	}
}
