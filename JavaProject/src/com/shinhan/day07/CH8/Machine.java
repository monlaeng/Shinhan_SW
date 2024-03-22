package com.shinhan.day07.CH8;

public interface Machine {
	
	void powerON(String title);
}

//1.interface 구현 class를 만든다 ... 만약에 만들어야하는 경우가 많다면 좋은 방법이 아니다.
//2.익명구현class를 만든다 ... 필요시마다 만들고 제거된다.
//3.interface 내에 method가 하나밖에 없다면 람다 표현식을 이용한다.
