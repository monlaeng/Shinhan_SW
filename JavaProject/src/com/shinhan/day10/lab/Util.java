package com.shinhan.day10.lab;

public class Util {

	public static <P extends Pair<A,B>, A, B> B getValue(P pair, A k) {
		if (pair.getKey().equals(k))
			return pair.getValue();
		return null;
	}
	
	//<A,B> : 제네릭타입 정의
	//B : return type
	public static <A,B,K>  B getValue3(Pair<A, B> pair, String k) {
		if (pair.getKey().equals(k))
			return pair.getValue();
		return null;
	}

	public static Integer getValue2(Pair<String, Integer> pair, String str) {
		if (pair.getKey().equals(str))
			return pair.getValue();
		return null;
	}

}
