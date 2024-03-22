package com.shinhan.day03;

public class LAB2Ex2Spliting {

	public static void main(String[] args) {
		LAB2Ex2Spliting p = new LAB2Ex2Spliting();
		String addr = "서울시,강남구,역삼동,삼성SDS멀티캠퍼스";
		String[] addrArr = p.split(addr, ',');
		System.out.println("배열 크기 : " + addrArr.length);
		for(int i=0; i<addrArr.length; i++){
			System.out.print(addrArr[i] + " ");
		}		
	}

	public String[] split(String str, char separator){

		int cnt = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i)==',') {
				cnt++;
			}
		}
		String[] result= new String[cnt+1];
		cnt = 0;
		String word = "";
		for(int j = 0; j < str.length(); j++) {
			if(str.charAt(j)==',') {
				result[cnt] = word;
				cnt++;
				word = "";
			} else {
				word += str.charAt(j);
			}
		}
		result[result.length-1] = word;

		return result;

	}
}
