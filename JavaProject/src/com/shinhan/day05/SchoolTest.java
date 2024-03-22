package com.shinhan.day05;


///패키지 내에 class가 존재하는지 찾는다.
//Modifier
//1. 접근지정자 1개 : public > protected > 생략 > private
//2. 활용방법 여러개 가능 : static, final, abstract, synchronized, ..........
public class SchoolTest {

	public static void main(String[] args) {
		Student st1 = new Student("홍길동", 20, 200201);
		Teacher te1 = new Teacher("이순신", 30, "JAVA");
		Employee em1 = new Employee("유관순", 40, "교무과");
		
		st1.print();
		te1.print();
		em1.print();
		
		st1.setAge(23);
		te1.setName("장영실");
		em1.setDept("행정");
		
		st1.print();
		te1.print();
		em1.print();
	}
	

	class Student {
		//instance 변수, 객체 생성 시 자동으로 초기화된다.
		private String name;
		private int age;
		private int id;
		
		
		
		Student(String name, int age, int id) {
			this.name = name;
			this.age = age;
			this.id = id;
			print();
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		void print() {
			System.out.printf("이  름 : %s  나 이 : %d  학  번 : %d \n", name, age, id);
		}
	}


}
