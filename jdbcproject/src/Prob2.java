public class Prob2 {

	public static void main(String[] args) {
		System.out.println(leftPad("Samsung",10,'#'));
		System.out.println(leftPad("SDS",5,'*'));
		System.out.println(leftPad("Multicampus",5,'@'));
		
	}

	 

	public static String leftPad(String str, int size, char fillChar) {
		//구현하시오.....return값 수정할것 
	try {
		if(str.length() < size) {
			throw new Exception("문자열의 길이보다 size가 큽니다.");
		} else {
			for(int i = size - str.length(); i >= 0; i--) {
				fillChar += fillChar;
				System.out.println(fillChar);
			}
			str = fillChar+str;
			System.out.println(str);
		}
	} catch(Exception e) {
		String message = e.getMessage();
	}
		
		return null;
	}

	
	
}

//구현하시오.
class IllegalSizeException  {
	 public IllegalSizeException() {
		 
	 }
	 
	 public IllegalSizeException(String message) {
		 super();
	 }
	 
}



