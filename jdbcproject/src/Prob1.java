
public class Prob1 {
	public static void main(String[] args) {
		String[] array={"황남기85점","조성호89점","한인성88점","독고정진77점"};
		printMaxScore(array);
	}	
	private static void printMaxScore(String[] array){
		// 구현하세요.
		String[][] arr = new String[array.length][2]; 
		int cnt = 0;
		for(String s1 : array) {
			
			for(int i = 0; i < s1.length()-1; i++) {
				int a = Character.getNumericValue(s1.charAt(i));
				if(a >=0 && a <=9) {
					if(arr[cnt][1] == null) {
						arr[cnt][1] = String.valueOf(a);
					} else {
						arr[cnt][1] += String.valueOf(a);
					}
				}
				else {
					if(arr[cnt][0] == null) {
						arr[cnt][0] = String.valueOf(s1.charAt(i));
					} else {
						arr[cnt][0] += String.valueOf(s1.charAt(i));
					}
				}
			}
			cnt++;
		}

		
		String maxValue = arr[0][1];
		int num = 0;
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i][1].compareTo(maxValue) > 0) {
				 maxValue = arr[i][1];
				 num = i;
			}
		}
		
		System.out.printf("최고점수는 %s님 %s점 입니다.", arr[num][0], maxValue);
	}	
}
