package com.shinhan.day10;

public class Util {

	public static <P extends Pair<K, V>,K, V> V getValue(P pair, K k) {
		if(pair.getKey().equals(k))
			return pair.getValue();
		return null;
	}
	
	public static <A , B> B getValue3(Pair<A, B> pair, String string) {
		if(pair.getKey().equals(string))
			return pair.getValue();
		return null;
	}
	public static Integer getValue2(Pair<String, Integer> pair, String string) {
		if(pair.getKey().equals(string))
			return pair.getValue(); 
		return null;
	}

}
