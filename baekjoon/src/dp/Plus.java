/**
 * 
 * 정수 4를 1, 2, 3의 조합으로 나타내는 방법은 총 7가지가 있다.1+1+1+1
 * 1+1+2
 * 1+2+1
 * 2+1+1
 * 2+2
 * 1+3
 * 3+1
 * 정수 n이 주어졌을 때, n을 1,2,3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
 * 
 * **/

package dp;

import java.util.Scanner;

public class Plus {
	static int[] d = new int[11];
	
	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		
		for(int test_case = 1; test_case <= T ;test_case++) {
			//n은 양수이며 11보다 작다.
			int N = sc.nextInt();			
			d[0] = 0;
			d[1] = 1;
			d[2] = 2;
			d[3] = 4;
			
			for(int i = 4; i<=N ; i++) {
				//점화식
				d[i] = d[i-1]+d[i-2]+d[i-3];
			}
			
			System.out.println(d[N]);
		}
	}
}
