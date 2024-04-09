import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Prob5_Fin {
	public static void main(String[] args) {
		int[] answer = { 1, 4, 4, 3, 1, 4, 4, 2, 1, 3, 2 };
		int[] counter = new int[4];		
		// 구현하시오 - 숫자들의 개수를 세어 저장하는 코드를 작성한다.
		
		/*for (int num : answer) {		//1번
			counter[num-1]++;
		} */
		
		//2번
		List<Integer> list = Arrays.stream(answer)
				.boxed()
				.collect(Collectors.toList());
		
		for(int i = 1; i <= 4; i++) {
			counter[i-1] = Collections.frequency(list, i);
		}

		// 구현하시오 - 출력결과와 같이 나오도록 작성한다.
		for (int i=0; i < counter.length; i++) {
			System.out.printf("%d의 갯수는 %d개 입니다.\n", i+1, counter[i]);
		}

	}
}
