/**
 * 
 * ���� 4�� 1, 2, 3�� �������� ��Ÿ���� ����� �� 7������ �ִ�.1+1+1+1
 * 1+1+2
 * 1+2+1
 * 2+1+1
 * 2+2
 * 1+3
 * 3+1
 * ���� n�� �־����� ��, n�� 1,2,3�� ������ ��Ÿ���� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * **/

package dp;

import java.util.Scanner;

public class Plus {
	static int[] d = new int[11];
	
	public static void main(String[] args) {
		// TODO �ڵ� ������ �޼ҵ� ����
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		
		for(int test_case = 1; test_case <= T ;test_case++) {
			//n�� ����̸� 11���� �۴�.
			int N = sc.nextInt();			
			d[0] = 0;
			d[1] = 1;
			d[2] = 2;
			d[3] = 4;
			
			for(int i = 4; i<=N ; i++) {
				//��ȭ��
				d[i] = d[i-1]+d[i-2]+d[i-3];
			}
			
			System.out.println(d[N]);
		}
	}
}
