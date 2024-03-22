package com.shinhan.day08;

import java.util.Objects;

public class CellPhone {
	String model;
	double battery;

	public CellPhone(String model) {
		this.model = model;
	}

	void call(int time) {

		if (time < 0) throw new IllegalArgumentException("통화시간입력오류");
		System.out.printf("통화 시간 : %d분\n", time);
		battery -= time * 0.5;
		if (battery < 0) battery = 0;
	}
	
	void charge(int time) {
		if (time < 0) throw new IllegalArgumentException("충잔시간입력오류");
		System.out.printf("충전 시간 : %d분\n", time);
		battery += time*3;
		if(battery > 100) battery = 100;
	}

	void printBattery() {
		System.out.printf("남은 배터리 양 : %4.1f\n", battery);
	}

	public boolean equals(Object otherObject) {
		if(!(otherObject instanceof CellPhone)) return false;
		CellPhone phone = (CellPhone) otherObject;
		return model.equals(phone.model);
	}
	
	
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		CellPhone other = (CellPhone) obj;
//		return Objects.equals(model, other.model);
//	}
	
	
}
