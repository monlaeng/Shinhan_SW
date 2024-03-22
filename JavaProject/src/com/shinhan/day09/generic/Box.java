package com.shinhan.day09.generic;

public class Box<A, B> {
	
	private A code;
	private B size;
	
	public Box(A code, B size) {
		this.code = code;
		this.size = size;
	}

	public A getCode() {
		return code;
	}

	public void setCode(A code) {
		this.code = code;
	}

	public B getSize() {
		return size;
	}

	public void setSize(B size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Box [code=" + code + ", size=" + size + "]";
	}
	
	
	

}
