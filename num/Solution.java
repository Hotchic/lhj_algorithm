

package num;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		
		int TC;
		int test_case;
		
		TC = sc.nextInt();
		
		for(test_case = 1; test_case <= TC; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			int result = 0;
			int numOf;
			
			numOf = sc.nextInt();
			for(int i = 0;i < numOf ;i++) {
				int num = sc.nextInt();
				result ^= num;
			}
        
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(result);
		}
	}

}
