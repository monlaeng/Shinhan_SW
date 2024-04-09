package com.shinhan.day11.collection;

import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Properties;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionTest2 {
	public static void main(String[] args) {
		f7();
	}
	
	//변경불가
	private static void f7() {
		String[] arr = {"자바", "디비", "웹", "프레임워크"};
		List<String> alist = Arrays.asList(arr);
		List<String> alist2 = List.of("자바", "디비", "웹", "프레임워크");
		Set<String> aset = Set.of("자바","디비", "웹", "프레임워크");	//중복 data는 불가, 중복 일 시 에러
		Map<Integer, String> amap = Map.of(1, "자바", 2 ,"디비", 3, "웹", 4,"프레임워크");	
		
		List<String> alist3 = new ArrayList<String>();
		alist3.add("A1");
		alist3.add("A2");
		alist3.add("A3");
		List<String> alist4 = List.copyOf(alist3);
		//alist4.add("AA4");	copyOf를 사용하여 만든 것은 수정 불가
		
		
		//alist.add("AAAA");	불가
		//alist2.add("AAAA");	불가
		//amap.put(5, "aaa");	불가
		for(Integer key:amap.keySet()) {
			System.out.println(key + "==" + amap.get(key));
		}
	}

	private static void f6() {
		//FIFO
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(100);
		queue.offer(300);
		queue.offer(400);
		queue.offer(500);
		queue.offer(200);
		
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}

	private static void f5() {
		//LIFO
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(100);
		stack.push(300);
		stack.push(400);
		stack.push(200);
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

	private static void f4() {
		TreeMap<String, Integer> treeMap = new TreeMap<> ();
		treeMap.put("apple1", 10);
		treeMap.put("apple2", 20);
		treeMap.put("apple3", 40);
		treeMap.put("apple4", 50);
		treeMap.put("apple5", 30);
		print(treeMap, "original");
		print2(treeMap, "origina1");
		print3(treeMap, "찾기");
		NavigableMap<String, Integer> datas = treeMap.descendingMap();
		for(String key :datas.keySet())
		{
			System.out.println(key + "==>" + treeMap.get(key));
		}
	}
	
	private static void print3(TreeMap<String, Integer> treeMap, String title) {
		for(String key:treeMap.keySet()) {
			System.out.println("===" + title);
			System.out.println(treeMap.firstKey());
			System.out.println(treeMap.firstEntry());
		}
	}

	private static void print2(NavigableMap<String, Integer> treeMap, String title) {
		System.out.println("===========");
		for(Map.Entry<String, Integer> entry:treeMap.entrySet()) {
			System.out.println(entry.getKey() + "==>" + entry.getValue());
		}
	}
	private static void print(TreeMap<String, Integer> treeMap, String title) {
		for(String key:treeMap.keySet()) {
			System.out.println(key + "==>" + treeMap.get(key));
		}
	}

	private static void f3() {
		TreeSet<Integer> scores = new TreeSet<Integer>();
		scores.add(87);
		scores.add(98);
		scores.add(75);
		scores.add(95);
		scores.add(80);
		print(scores, "ascending");
		//print2(scores);
		
//		NavigableSet<Integer> descScoreSet = scores.descendingSet();
//		for(Integer data:descScoreSet) {
//			System.out.println(data);
//		}
//		print(scores.descendingSet(), "Descending");
//		print(scores.tailSet(80, true), "tailSet");	//>=80 tailSet = 크거나 작다.
		print(scores.subSet(80,true,90, true), "subSet");	//>=80 tailSet = 크거나 작다.
	}

	private static void print2(TreeSet<Integer> scores) {
		System.out.println("가장 낮은 점수: " + scores.first());
		System.out.println("가장 높은 점수: " + scores.last());
		System.out.println("95보다 낮은 점수: " + scores.lower(95));
		System.out.println("95보다 높은 점수: " + scores.higher(95));
		System.out.println("95보다 낮은 점수: " + scores.floor(95));
		System.out.println("96보다 높은 점수: " + scores.ceiling(96));
	}

	private static void print(Set<Integer> scores, String title) {
		System.out.println(title + " Sort----------------------");
		for(Integer data:scores) {
			System.out.println(data);
		}
		
	}

	private static void f2() {
		Properties pro = new Properties() ;
		
		try {
			pro.load(CollectionTest2.class.getResourceAsStream("oracleDB.properties"));
			String driver = pro.getProperty("driver");
			String url = pro.getProperty("url");
			String username= pro.getProperty("username");
			String password = pro.getProperty("password");
			String myname = pro.getProperty("myname");
			String myname2 = pro.getProperty("myname2", "AAA");		//못 찾으면 줄 default 값 지정
			
			System.out.println(driver);
			System.out.println(url);
			System.out.println(username);
			System.out.println(password);
			System.out.println(myname);
			System.out.println(myname2);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	private static void f1() {
		//Hashtable: 쓰레드에 안정적: 멀티쓰레드 환경O
		Map<String, Integer> map = new Hashtable<>(); //HashMap: 쓰레드에 안정적X
		Thread t1 = new Thread() {
			public void run() {
				for(int i=1; i<=1000; i++) {
					System.out.println(getName() + "!!!!-----" + i);
					map.put(String.valueOf(i), i); //{"1":1, "2":2, ...}
				}
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				for(int i=1001; i<=2000; i++) {
					map.put(String.valueOf(i), i); //{"1":1, "2":2, ...}
				}
			}
		};
		t1.start(); t2.start();
		try {
			t1.join();//t1이 종료될때까지 기다림
			t2.join();//t2이 종료될때까지 기다림
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println("entry개수:"+map.size());
	}

}

//Map(키,값 쌍) 키중복불가, hashcode(), equals()
//: HashMap, TreeMap(순서있음, Comparable구현),
//HashTable(동기화가능)
