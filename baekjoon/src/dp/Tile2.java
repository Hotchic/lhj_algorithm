/**
 * 2��n ���簢���� 2��1�� 2��2 Ÿ�Ϸ� ä��� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * ù° �ٿ� n�� �־�����.(1<= n <= 1,000)
 * **/

package dp;

import java.util.Scanner;

public class Tile2 {

	public static void main(String[] args) {
		// TODO �ڵ� ������ �޼ҵ� ����
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
