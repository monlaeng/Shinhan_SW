package com.shinhan.day07.CH8;

public class MachineUsing {
	
	//1.field
	Machine v1 = new Machine() {
		
		@Override
		public void powerON(String title) {
			System.out.println("2.익명구현 class를 만든다.");
		}
	};
	public static void main(String[] args) {
		
		//**구현 class 사용
		Machine v3 = new MachineImpl();
		call(v3);
		
		
		//2.local 변수
		Machine v2 = new Machine() {
			
			@Override
			public void powerON(String title) {
				System.out.println("2.익명구현 class를 만든다.");
			}
		};
		call(v2);
		
		call((s) -> System.out.println(s + "람다표현식"));
		
		//3.함수의 매개변수 이용
		call(new Machine() {
			
			@Override
			public void powerON(String title) {
				System.out.println("2.익명구현 class를 만든다.");
			}
		});
	}
	private static void call(Machine machine) {
		machine.powerON("***");
	}
}
