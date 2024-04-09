package com.shinhan.day12;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

//Collection
//List : add한순서있음, index가능, 중복가능 
// =>ArrayList(중간삽입,삭제 비효율적, 추가효율)
// =>LinkedList(다음데이터, 전데이터의 주소가짐, 공간차지, 중간삽입, 삭제 효율적)
// =>Vector(동기화지원, 멀티쓰레드환경에 안정적)
//Set : 순서없음, 중복불가 =>HashSet(hashcode(), equals()), 
//						TreeSet(add시 sort한다.. compareTo)
//Map : 키와 값의 쌍(entry), 키는 set이다. => HashMap, HashTable, TressMap, Properties
public class Review {
	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
		f6();
	}

	private static void f6() {
		//Map<Student, Product> map = new HashMap<>();
		//Map<Student, Product> map = new TreeMap<>(); //크기비교 sort
		Map<Student, Product> map = new Hashtable<>();
		map.put(new Student("A", 100), new Product(1, "노트북1", "삼성", 200));
		map.put(new Student("A", 100), new Product(2, "노트북2", "삼성", 200));
		map.put(new Student("B", 500), new Product(3, "노트북3", "삼성", 200));
		map.put(new Student("C", 500), new Product(4, "노트북4", "삼성", 200));
		map.put(new Student("D", 400), new Product(5, "노트북5", "삼성", 200));
		print(map, "key가 Studnet");
	}

	private static void print(Map<Student, Product> map, String title) {
		System.out.println("=====" + title);
		for(Student key:map.keySet()) {
			System.out.println(key + "==>" + map.get(key));
		}
		System.out.println("=======entryset======");
		for(Entry<Student, Product> entry:map.entrySet()) {
			System.out.println(entry.getKey() + "==>" + entry.getValue());
		}
	}

	//메서드 이름, 매개변수 개수와 타입이 같으면 Overloading아니다.
//	private static void print(Map<Student, Product> map) {
//		
//	}
	
	private static void print(Map<String, Integer> map) {
		System.out.println("=======keyset======");
		for(String key:map.keySet()) {
			System.out.println(key + "==>" + map.get(key));
		}
		System.out.println("=======entryset======");
		for(Map.Entry<String,Integer> entry:map.entrySet()) {
			System.out.println(entry.getKey() + "==>" + entry.getValue());
		}
	}

	private static void f5() {
		Map<String, Integer> map = new HashMap<>();
		map.put("A", 100);
		map.put("A", 200); //덮어쓰기
		map.put("B", 100);
		map.put("C", 100);
		map.put("D", 100);
		print(map.keySet());
		print(map);
	}



	private static void f4() {
		Set<Student> data = new TreeSet<>();
		data.add(new Student("A", 70));
		data.add(new Student("A", 70)); //
		data.add(new Student("B", 80));
		data.add(new Student("C", 70)); // compareTo할때 점수같은거 처리안하면 안들어가네
		data.add(new Student("B", 80)); //
		print(data);
	}

	private static void f3() {
		Set<Student> data = new HashSet<>();
		data.add(new Student("A", 70));
		data.add(new Student("A", 70)); //
		data.add(new Student("B", 80));
		data.add(new Student("C", 90));
		data.add(new Student("B", 80)); //
		print(data);
	}

	private static void print(Set<Student> data) {
		for (Student s : data) {
			System.out.println(s);
		}
	}

	private static void f2() {
		Set<String> data = new HashSet<>();
		data.add("월");
		data.add("월");
		data.add("토");
		data.add("토");
		print(data);

	}

	private static void f1() {
//		List<String> data = new ArrayList<>();
//		List<String> data = new LinkedList<>();
		List<String> data = new Vector<>();
		data.add("월");
		data.add("월");
		data.add("토");
		data.add("토");
		print(data);
	}

//	private static void print(List<String> data) {
//		for(String s: data) {
//			System.out.println(s);
//		}
//	}

	private static void print(Collection<String> data) {
		System.out.println("============Collection<String>");
		for (String s : data) {
			System.out.println(s);
		}
	}

}
