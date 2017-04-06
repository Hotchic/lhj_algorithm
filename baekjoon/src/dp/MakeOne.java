/**
 * �ڿ��� N�� 1�� ����� �ּ� ����� ���� ���ϱ�
 * 1. N�� 3���� ����������� /3 �� �� �ִ�.
 * 2. N�� 2�� ������ �������� /2 �� �� �ִ�.
 * 3. N-1 �� �� �ִ�.
 * **/

package dp;

import java.util.Scanner;

public class MakeOne {
	static int[] d = new int[1000001];
	public static void main(String[] args) {
		// TODO �ڵ� ������ �޼ҵ� ����
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		
		System.out.println(bottom_up(N));
		//System.out.println(top_down(N));
		
	}

	public static int top_down(int N) {
		if(N == 1) return 0;
		if(d[N] > 0) return d[N];
		d[N] = top_down(N-1) + 1;
		if(N%2 == 0) {
			int temp = top_down(N/2) + 1;
			if (d[N] > temp) d[N] = temp;
		}
		if(N%3 == 0) {
			int temp = top_down(N/3) + 1;
			if (d[N] > temp) d[N] = temp;
		}
		
		return d[N];
	}
	
	public static int bottom_up(int N) {
		d[1] = 0;
		for(int i=2;i<=N;i++) {
			d[i] = d[i-1] + 1;
			if(i%2 == 0 && d[i] > d[i/2]+1) {
				d[i] = d[i/2] + 1;
			}
			if(i%3 == 0 && d[i] > d[i/3]+1) {
				d[i] = d[i/3] + 1;
			}
		}
		return d[N];
	}
}
