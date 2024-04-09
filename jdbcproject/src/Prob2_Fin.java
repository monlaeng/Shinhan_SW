public class Prob2_Fin {

	public static void main(String[] args) {
		System.out.println(leftPad("Samsung", 10, '#'));
		System.out.println(leftPad("SDS", 5, '*'));
		System.out.println(leftPad("Multicampus", 5, '@'));

	}

	private static String leftPad(String str, int size, char ch) {
		String result = "";
		int fillCharNum = size - str.length();
		try {
			if (fillCharNum < 0) {
				throw new IllegalSizeException("문자열의 길이보다 size가 큽니다.");
			}			
			result = Character.toString(ch).repeat(fillCharNum)+str;
			//result = ("" + ch).repeat(fillCharNum)+str;
		}catch(IllegalSizeException aa) {
			result = aa.getMessage();
		}
		return result;
	}

	public static String leftPad2(String str, int size, char fillChar) {
		// 구현하시오.....return값 수정할것
		String result = "";
		int fillCharNum = size - str.length();
		if (fillCharNum < 0) {
			try {
				throw new IllegalSizeException();
			} catch (IllegalSizeException e) {
				return "문자열의 길이보다 size가 큽니다.";
			}
		}
		result += Character.toString(fillChar).repeat(fillCharNum) + str;

		return result;
	}
}

//구현하시오.
class IllegalSizeException extends RuntimeException {

	public IllegalSizeException() {
		super();
	}
	public IllegalSizeException(String message) {
		super(message);
	}
	
}






