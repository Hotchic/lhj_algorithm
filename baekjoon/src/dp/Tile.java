/**
 * 2��n ũ���� ���簢���� 1��2, 2��1 Ÿ�Ϸ� ä��� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Ʒ� �׸��� 2��5 ũ���� ���簢���� ä�� �� ���� ����� ���̴�
 * */

package dp;

import java.util.Scanner;

public class Tile {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1<= N <= 1000
		int[] d = new int[1001];
		int N = sc.nextInt();
		
		d[0] = 1;
		d[1] = 1;
		
		for(int i = 2; i<=N ; i++) {
			//��ȭ��
			d[i] = d[i-1]+d[i-2];
			d[i] %= 10007;
		}
		
		System.out.println(d[N]);
	}

}
