package com.shinhan.day12;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class StreamTest {
	public static void main(String[] args) throws URISyntaxException, IOException {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		f6();
		f7();
	}

	//파일로부터 스트림얻기
	private static void f7() throws URISyntaxException, IOException {
		URI uri = StreamTest.class.getResource("data.txt").toURI(); //getResource안쓰면 경로 프로젝트부터 시작 //쓰면 현재경로부터
		Path path = Paths.get(uri);
		
		//Stream : Files.lines(path)
		Files.lines(path).forEach(line->{
			System.out.println(line);
		});
	}

	private static void f6() {
		IntStream.range(1, 6).forEach(i->System.out.println(i)); //1~5
		System.out.println("-------------------");
		IntStream.rangeClosed(1, 6).forEach(i->System.out.println(i)); //1~6
		
	}

	private static void f5() {
		String[] arr = {"홍길동", "심은정", "정민교"};
		Arrays.stream(arr).forEach(name -> System.out.println(name));
		
		int[] scores = {100,99,88,77};
		double result = Arrays.stream(scores).average().getAsDouble();
		System.out.println(result);
	}

	private static void f4() {
		List<Product> list = new ArrayList<>();
		//1<= <6
		IntStream.range(1, 6).forEach(i->{
			Product p = new Product(i, "상품"+i, "멋진회사", (int)(Math.random()*10000));
			list.add(p);
		});
		//내부반복자 이용하여 출력
		list.stream().forEach(p->System.out.println(p));
		//내부반복자 이용하여 가격합계구하기
		int total = list.stream().mapToInt(p->p.getPrice()).sum();
		System.out.println(total);
	}

	private static void f3() {
		List<Student> data = new ArrayList<>(); 
		data.add(new Student("A",100));
		data.add(new Student("C",400));
		data.add(new Student("A",100));
		data.add(new Student("D",200));
		data.add(new Student("B",100));
		
		//map: 변형하다
		double avg = data.stream().mapToInt(s->s.getScore()).average().getAsDouble();
		System.out.println(avg);
		System.out.println(923/5.0);
	}

	private static void f2() {
//		Set<String> data = new HashSet<>(); //Set은 중복체크
		List<String> data = new ArrayList<>(); 
		data.add("홍길동");
		data.add("신용권");
		data.add("김자바");
		data.add("김자바");
		data.add("김자바");
		data.add("김자바");
		
		//내부반복자(Stream)
		data.stream().forEach(a->{
			System.out.println(a + "Stream===thread이름:"+Thread.currentThread().getName());
	});
			
		
		//**병렬처리
		data.parallelStream().forEach(a->{
			System.out.println(a + "paralle===thread이름:"+Thread.currentThread().getName());
		});
	}

	private static void f1() {
		Set<String> data = new HashSet<>();
		data.add("홍길동");
		data.add("신용권");
		data.add("김자바");

		// 외부반복자(Iterator)
		for (String s : data) {
			System.out.println(s);
		}
	}

}
