package com.shinhan.day08;

//규격서
@FunctionalInterface	//람다표현식이 가능한지 check하는 annotation
interface JDBCInterface {
	//1.상수
	//2.추상메서드...구현 class가 반드시 구현할 의무가 있다.
	public abstract void connection();
	//3.default method: 구현가능, 구현 class가 공통적으로 사용하는 기능, 재정의 가능
	//4.static method: 구현가능, 구현 class가 공통적으로 사용하는 기능, 재정의 불가능
	//5.private method: default method에서만 호출가능
}

//구현 class를 만들기
class OracleDB implements JDBCInterface {

	@Override
	public void connection() {
		System.out.println("Oracle DB 연결합니다.");
	}
	 
}
class MySQLDB implements JDBCInterface {
	
	@Override
	public void connection() {
		System.out.println("MySQL DB 연결합니다.");
	}
	
}

public class Review {
	
	public static void main(String[] args) {
		work(new OracleDB()); 
		work(new MySQLDB()); 
		
		work(new JDBCInterface() {
			
			@Override
			public void connection() {
				System.out.println("익명구현 class에서 method를 재정의함");
				method();
			}
			void method() {
				System.out.println("method 추가함");
			}
		});
		work(() -> System.out.println("람다표현식으로 method를 재정의함"));
	}

	private static void work(JDBCInterface db) {
		db.connection();
		
	}
}
