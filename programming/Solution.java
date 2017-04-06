package programming;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int TC;
		int test_case;

		TC = sc.nextInt();        
		for(test_case = 1; test_case <= TC; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			int winner = 0;
			int n = sc.nextInt();
			int[] playerScore = new int[n];
			int[] nextScore = new int[n];
			int result = 0;
			
			for(int i = 0; i<n ; i++) {
				playerScore[i] = sc.nextInt();
			}
        
			Arrays.sort(playerScore);
			
			for(int i = 0; i < n ; i++) {
				nextScore[i] = playerScore[i] + (n-i); 
				if(nextScore[i] > winner) {
					winner = nextScore[i];
				}
			}
			
			for(int i=0;i<n;i++) {
				if(playerScore[i] >= (winner - n)) {
					result++;
				}
			}
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(result);
		}
		
	}

}
