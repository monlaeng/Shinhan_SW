import java.util.Arrays;

public class 놀이공원티켓판매 {
	public static void main(String[] args) {
		int[] tickets = { 10, 8, 20000 };
		int[][][] requests = { { { 2, 3 }, { 1, 7 }, { 2, 4 }, { 3, 5 } }, { { 1, 9 }, { 3, 6 }, { 2, 5 } },
				{ { 3, 1 }, { 2, 5 }, { 2, 10 }, { 3, 8 }, { 1, 2 } } };
		for (int testcast = 0; testcast < tickets.length; testcast++) {

			System.out.println("-------------------testcast[" + testcast + "]");
			int result = solution(tickets[testcast], requests[testcast]);
			System.out.println(result);

			for (int[] arr : requests[testcast]) {
				System.out.println(Arrays.toString(arr));
			}
		}

	}

	// tickets: 티켓 수
	// requests: 회원 등급, 티켓 구매 수량
	public static int solution(int tickets, int[][] requests) {
        //이부분 구현 
		return 0;

	}

}
