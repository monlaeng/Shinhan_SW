package com.shinhan.day07;

class VolTest {
	public static void main(String args[]) {
		//Volume은 interface이거나 추상 class로 만들 수 있다.
		//추상 class 이었다면 상속 받아서  Speaker, Radio, TV
		//interface였다면 implements
		Volume[] v = new Volume[3];
		v[0] = new Speaker();
		v[1] = new Radio();
		v[2] = new TV();
		for (int i = 0; i < v.length; i++) {
			for (int j = 1; j <= 3; j++) {
				v[i].volumeUP(200);
			}
			for (int j = 1; j <= 3; j++) {
				v[i].volumeDown(300);
			}
		}
	}
}
