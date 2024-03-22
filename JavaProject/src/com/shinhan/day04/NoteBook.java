package com.shinhan.day04;

public class NoteBook {
	
	//1.field : object마다 다른 객체와 구별되는 값을 저장하기 위한
	//field : non-static(instance변수) -> 반드시 생성 후 사용 가능
	//		  static(class 변수 ,공유변수, C언어의 share변수) -> 객체생성과 무관하다
	private String model;
	private int price;
	
	//
	static int count;

	//2.constructor : 값초기화
	public NoteBook(String model, int price) {
		this.model = model;
		this.price = price;
		count++;
	}
	//3.일반메서드
	//3.getter(읽기)/setter (변경)

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "NoteBook [model=" + model + ", price=" + price + "]";
	}
	
}
