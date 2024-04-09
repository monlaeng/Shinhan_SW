import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prob1_Fin {
	public static void main(String[] args) {
		String[] array={"황남기85점","조성호89점","한인성88점","독고정진77점"};
		printMaxScore(array);
	}	
	private static void printMaxScore(String[] array) {
		String regExp = "([ㄱ-ㅎ가-힣]+)([0-9]+)점";	//정규표현식
		String maxName = "";
		int maxScore = -1;
		for(String data : array) {
			Pattern pattern = Pattern.compile(regExp);
			Matcher matcher = pattern.matcher(data);
			if(matcher.find()) {
				String name = matcher.group(1);
				String score = matcher.group(2);
				int iscore = Integer.parseInt(score);
				if(maxScore < iscore) {
					maxScore = iscore;
					maxName = name;
				}
				
			}
			
		}
		System.out.println("최고점수는 " + maxName + "님 "  + maxScore + "점 입니다.");
	}
	private static void printMaxScore1(String[] array){
		// 구현하세요.
		String maxName = "";
		int maxScore = -1;
		for(String data:array) {
			char[] arr = data.toCharArray();
			String name="", score = "";
			for(char ch:arr) {
				if(!Character.isDigit(ch)) name += ch;
				else
					score += ch;
			}
			if(maxScore <Integer.parseInt(score)) {
				maxScore = Integer.parseInt(score);
				maxName = name.substring(0, name.length()-1);
			}
			
		}
		System.out.println("최고점수는 " + maxName + "님 "  + maxScore + "점 입니다.");
	}	
}
