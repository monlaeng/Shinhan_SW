package com.shinhan.day12;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest2 {
	static List<Student> data2 = new ArrayList<>(); 
	static {
		data2.add(new Student("신용권",100));
		data2.add(new Student("정민교",99));
		data2.add(new Student("신용권2",100));
		data2.add(new Student("심은정",88));
		data2.add(new Student("심은지",100));		
	}
	
	
	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		f6();
//		f7();
//		f8();
//		f9();
//		f10();
//		f11();
//		f12();
//		f13();
//		f14();
//		f15();
//		f16();
//		f17();
		f18();
	}
	
	private static void f18() {
		List<Student> data = new ArrayList<>(); 
		data.add(new Student("신용권",100,"남"));
		data.add(new Student("정민교",99,"남"));
		data.add(new Student("신용권2",100,"남"));
		
		data.add(new Student("심은정",88,"여"));
		data.add(new Student("심은지",50,"여"));
		
		Map<String, List<Student>> map =
			data.stream().collect(Collectors.groupingBy(s->s.getGender()));
		
		//map.get("남").forEach(st->System.out.println(st));
		map.get("여").forEach(st->System.out.println(st));

		Map<String, Double> map2 =
		data.stream().collect(
				Collectors.groupingBy(
						s->s.getGender(), Collectors.averagingDouble(st->st.getScore()))
				);
		System.out.println(map2);
	}

	private static void f17() {
		//List->Map  {심은정=88, 신용권=100, 심은지=100, 신용권2=100, 정민교=99}
		//map은 키값이 중복불가
		Map<String, Integer> map =
				data2.stream()
				.collect(Collectors.toMap(s->s.getName(), s->s.getScore()));
		System.out.println(map);
		
		
		data2.stream()
		.collect(Collectors.toSet()).forEach(s->{
			System.out.println(s);
		});
		
		System.out.println(map);
	}

	private static void f16() {
		//Student들의 점수 평균구하기
		List<Student> data3 = new ArrayList<>();
		data2.stream()
		.mapToInt(st->st.getScore())
		.average()
		.ifPresentOrElse(d->{
			System.out.println("평균:" + d);
		}, ()->{
			System.out.println("값없음");
		});
		
		int total = data2.stream()
				//.mapToInt(st->st.getScore()).sum();
				.mapToInt(Student::getScore).sum();
		System.out.println("합계:"+total);
		
		data2.stream()
		.mapToInt(Student::getScore)
		.reduce((a,b)->a+b)
		.ifPresentOrElse(i->{
			System.out.println("있음:"+i);
		}, ()->{
			System.out.println("없음");
		});;
	}

	private static void f15() {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		int total = Arrays.stream(arr).sum();
		long count = Arrays.stream(arr).count();
		OptionalDouble op = Arrays.stream(arr).average();
		op.ifPresent(a->System.out.println(a));
		double result = op.orElse(0); //default값을 주기위함
		System.out.println(result);
		
		//첫번째arg: 소비자 두번째arg:Runnable
		op.ifPresentOrElse(a->{
			System.out.println("있다" + a);
		}, ()->System.out.println("없다"));
		
		System.out.println("total = "+total);
		System.out.println("count = "+count);
	}

	private static void f14() {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		boolean result1 = Arrays.stream(arr).allMatch(a-> a<=10);
		boolean result2 = Arrays.stream(arr).allMatch(a-> a<10);
		boolean result3 = Arrays.stream(arr).anyMatch(a-> a<10);
		boolean result4 = Arrays.stream(arr).anyMatch(a-> a>10);
		boolean result5 = Arrays.stream(arr).noneMatch(a-> a>10);
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
		System.out.println(result5);
	}

	private static void f13() {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		//forEach: 최종처리 메서드
		//peek: 중간처리메서드
		Arrays.stream(arr).forEach(data->System.out.println(data));
		System.out.println("-----------------------------------------");
		int result = Arrays.stream(arr).peek(data->System.out.println(data)).sum();
		System.out.println(result);
	}

	private static void f12() {
		// Product를 이용해서 Sort연습(pno, name, company, price)
		List<Product> plist = new ArrayList<>();
		IntStream.rangeClosed(100, 105).forEach(pid->{
			Product p = new Product(pid, "상품"+(pid%100), "신한", 10*pid);
			plist.add(p);
		});
		
		Comparator<Product> com1 = (a,b)->a.getPno()-b.getPno();
		Comparator<Product> com2 = new Comparator<Product>() {
			//Product의 pno로 descending

			@Override
			public int compare(Product a, Product b) {
				return b.getPno() - a.getPno();
			}
		};
		
		plist.stream()
//		.sorted()
		.sorted(com1) //Product의 pno로 ascending
		.forEach(p->System.out.println(p));
		
		plist.stream()
//		.sorted()
		.sorted(com2) //Product의 pno로 descending
		.forEach(p->System.out.println(p));
		
	}

	private static void f11() {
		//Student는 implements Comparable: compareTo() => score asc, name desc
		//data2.stream().sorted().forEach(st -> System.out.println(st));

		Comparator<Student> cp1 = (a,b)->a.getName().compareTo(b.getName());
		Comparator<Student> cp2 = new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o2.getName().compareTo(o1.getName());
			}
		};
		
		Comparator<Student> cp3 = (a,b)->a.getScore()-b.getScore(); //score asc
		data2.stream()
		.sorted(cp1) //이름으로 asc
		.forEach(st -> System.out.println(st));
	}

	private static void f10() {
		
		String s = " 100 ";
		int i = Integer.parseInt(s.trim());
		System.out.println(i+200);
		
		List<String> list2 = 
				Arrays.asList("10 ,20 ,30","40,50","60, 70", "80, 90, 100");
		
		double result =
		list2.stream()
		.flatMap(str-> {
			String[] arr = str.split(",");
			Integer[] arr2 = new Integer[arr.length];
			for(int index=0; index<arr.length; index++) {
				arr2[index] = Integer.parseInt(arr[index].trim());
			}
			return Arrays.stream(arr2);
		})
		.mapToInt(intData -> intData.intValue()).average().getAsDouble();
		//.forEach(w->System.out.println(w));
		System.out.println(result);
	}

	private static void f9() {
		List<String> list2 = Arrays.asList("10 ,20 ,30 ","30,40,50","60, 70");
		
//		int[] arr3 = {1,2,3,4};
//		double d2 = Arrays.stream(arr3).average().getAsDouble();
//		System.out.println(d2);
		
		double d = list2.stream()
		.flatMap(one->{
			String[] arr = one.split(",");
			Integer[] arr2 = new Integer[arr.length]; //Wrapper클래스여야
			for(int i=0; i<arr.length; i++) {
				arr2[i] = Integer.parseInt(arr[i].trim());
			}
			return Arrays.stream(arr2);
		}).mapToInt(aa->aa.intValue()).average().getAsDouble();
//		.forEach(data -> System.out.println(data));
		//Stream : new Integer(10) new Integer(20) 30 30 40 50 60 70
		//IntStream
		System.out.println(d);
	}

	private static void f8() {
		List<String> list1 = new ArrayList<String>();
		list1.add("this is a java");
		list1.add("i am a best developer");
		
		String[] arr = list1.get(0).split(" ");
		Arrays.stream(arr).forEach(a->System.out.println(a));
		
		//flatMap(Function<T,R>) T가 들어가고 R이 나온다.
		//T: String
		//R: stream
		list1.stream()
		.flatMap(data-> Arrays.stream(data.split(" ")))
		.forEach(data->System.out.println(data));
		
	}

	private static void f7() {
		int[] arr = {1,2,3,4,5};
		
		Arrays.stream(arr)
		.asDoubleStream()
		.forEach(d->System.out.println(d));		
		
		Arrays.stream(arr)
		.boxed() //new Integer(1)
//		.forEach(d->System.out.println(d));
		.forEach(d->System.out.println(d.intValue()));
	}

	private static void f6() {
		//map은 들어간것과 나오는 것이 다르다. (변형)
		data2.stream()
		.map(st->st.getName()+"$")
		.forEach(name->System.out.println(name));
	}

	private static void f5() {
		List<Student> data = new ArrayList<>(); 
		data.add(new Student("신용권",100));
		data.add(new Student("정민교",99));
		data.add(new Student("신용권",100));
		data.add(new Student("심은정",88));
		data.add(new Student("심은지",50));
		
		//mapToInt: 객체(Student)가 들어가고 int(score)가 나온다.
		data.stream()
		.mapToInt(st->st.getScore()) //IntStream
		.forEach(st -> System.out.println(st));
		
		IntStream scoreStream = data.stream()
								.mapToInt(st->st.getScore()); //IntStream
		double avg = scoreStream.average().getAsDouble();
		System.out.println(avg);
	}

	private static void f4() {
		List<Product> list = new ArrayList<>();
		//1<= <6
		IntStream.range(1, 6).forEach(i->{
			Product p = new Product(i, "상품"+i, "멋진회사", (int)(Math.random()*10000));
			list.add(p);
		});
		
		list.stream()
//		.filter(p -> p.getPno()>=3)
//		.filter(p -> p.getName().startsWith("상품"))
		.filter(p -> p.getPrice() >=5000)
		.forEach(p -> System.out.println(p));
	}

	private static void f3() {
		List<Student> data = new ArrayList<>(); 
		data.add(new Student("신용권",100));
		data.add(new Student("정민교",99));
		data.add(new Student("신용권",100));
		data.add(new Student("심은정",88));
		data.add(new Student("심은지",50));
		
		System.out.println("=======이름이 심으로 시작 ==========");
		data.stream()
		.distinct() //코드만들어줘서..
		.filter(st -> st.getName().startsWith("심"))
		.forEach(st -> System.out.println(st));
		
		System.out.println("=======st.getScore()>=90==========");
		data.stream()
		.distinct() //코드만들어줘서..
		.filter(st -> st.getScore()>=90)
		.forEach(st -> System.out.println(st));
	}

	private static void f2() {
		List<String> list = new ArrayList<String>();
		list.add("A1");list.add("A1");list.add("A1");
		list.add("B");list.add("B");
		list.add("C3");list.add("C3");
		list.add("D");
		
//		list.stream().forEach(name -> System.out.println(name)); //변수가 여러개면 ()묶음
		
		//distinct() : 중복없애기
		//filter(Predicate) : 조건에 맞으면 선택 (Predicate의 return이 true)
		list.stream()
		.distinct() //중복제거 //set에 넣어서 중복제거하는거보다 좋겠다.
		.filter(name -> name.length()>=2) //조건
		.forEach(name -> System.out.println(name));
	}

	private static void f1() {
		//하나의 문자를 몇바이트처리하는가? UTF-8(3byte처리)
		System.out.println(Charset.defaultCharset());
	}

}
