/**
 * 2×n 직사각형을 2×1과 2×2 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
 * 첫째 줄에 n이 주어진다.(1<= n <= 1,000)
 * **/

package dp;

import java.util.Scanner;

public class Tile2 {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] d = new int[1001];
		d[0] = 1;
		d[1] = 1;
		
		for(int i = 2; i <= N ; i++) {
			d[i] = d[i-1] + d[i-2] + d[i-2];
			d[i] %= 10007;
		}
		
		System.out.println(d[N]);
	}

}
