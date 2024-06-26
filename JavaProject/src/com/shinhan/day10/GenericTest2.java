package com.shinhan.day10;

import java.util.Arrays;
import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
class Student implements Comparable<Student>{
	String name;
	int score;
	@Override
	public int compareTo(Student obj) {
		//점수로 desc, 같은 점수는 이름으로  asc
		
		if(obj.score==score) {
			return name.compareTo(obj.name);
		}
		return obj.score - score;
		//return name.compareTo(obj.name); // *(-1) 해주면 Descending
		//return score - obj.score;		//앞 뒤 순서를 바꾸면 Descending
	}

}

public class GenericTest2 {
	public static void main(String[] args) {
		f5();
	}

	private static void f5() {
		Car[] arr = {
				new Car("A", 100, "black"),
				new Car("C", 200, "red"),
				new Car("B", 300, "blue"),
				new Car("B", 300, "green"),
				new Car("C", 400, "red"),
		};
		print2(arr, "original");
		Arrays.sort(arr);
		print2(arr, "price desc, model desc, color asc");
		//가격 asc
		Arrays.sort(arr,(o1, o2) -> {
			int result = o1.price - o2.price;
			if(result == 0) {
				int result2 = o2.model.compareTo(o1.model);
				if(result2 == 0) { 
					return o2.color.compareTo(o1.color);
				}
				return result2;
			}
			return result;
		});
		print2(arr, "가격 asc, model desc, color desc");
	}
	
	static void print2(Car[] arr, String title) {
		System.out.println("*******" + title + "*******");
		for(Car car:arr) {
			System.out.println(car);
		}
	}

	private static void f4() {
		Student[] arr = {
				new Student("A", 10),
				new Student("C", 40),
				new Student("E", 40),
				new Student("A", 50),
				new Student("D", 30),
		};
		print(arr, "original");
		//Comparable interface를 구현해야 Sort가 가능하다.
		Arrays.sort(arr);
		print(arr, "score descending, name Ascending");
		//이미구현 Sort 기준을 변경
		Arrays.sort(arr, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				//이름으로 desc, 점수로 asc
				int result = o2.name.compareTo(o1.name);
				if(result == 0)
					return o1.score - o2.score;
				return result;
			}
		});
		print(arr, "이름으로 desc, 점수로 asc");
		
		Arrays.sort(arr, (o1, o2) -> {
				int result = o1.name.compareTo(o2.name);
				if(result == 0)
					return o2.score - o1.score;
				return result;
			});
		print(arr, "이름으로 asc, 점수로 desc");
		
	}
	
	static void print(Student[] arr, String title) {
		System.out.println("======" + title + "======");
		for(Student st:arr) {
			System.out.println(st);
		}
	}

	private static void f2() {
		String[] arr = {"Hello", "Coffee","Java", "Computer", "java"};
		System.out.println("original : " + Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println("Ascending Sort : " + Arrays.toString(arr));
		//A(65), a(97)
		//2.익명구현 class
		/*Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareToIgnoreCase(o1);		//대소문자 상관 없다는 조건
			}
		}); */
		
		//람다표현식
		Arrays.sort(arr,(String o1, String o2) -> o2.compareToIgnoreCase(o1));
		System.out.println("Descending Sort : " + Arrays.toString(arr));
	}

	private static void f1() {
		int[] arr = {100, 55, 22, 99, 94, 88};
		System.out.println("original : " + Arrays.toString(arr));
		Arrays.sort(arr); 
		System.out.println("Ascending Sort : " + Arrays.toString(arr));
		
		//descending Sort
		//1.구현 class
		//Arrays.sort(arr, new MyDescendingSort());
		//2.익명 class
		/*Arrays.sort(arr, new Comparator<Integer>()
				@Override
				puglic int compare(Integer o1, Integer o2) {
			return 02-o1;
		};*/
		//3.람다표현식
//		Arrays.sort(arr,(Integer o1, Integer o2) -> o2.compareTo(o1));
		System.out.println("Descendeing sort" + Arrays.toString(arr));
	}
}
