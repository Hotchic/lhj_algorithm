package virus;
import java.util.Scanner;

/**
 * [�ڵ�׶���] - ���̷��� ��å[SCPC 2016 - 1�� ����]
 * 
 * **/

class Solution {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();        
		for(test_case = 1; test_case <= T; test_case++) {
			
			int K = sc.nextInt(); //�� ������ ����
			int L = sc.nextInt(); //�����Ǿ ��Ƴ��� �ּ� �κ� �� 
			int V = sc.nextInt(); //����
			int E = sc.nextInt(); //����
			
			int[][] graph = new int[V+1][V+1]; // �׷��� 
			int[] degree = new int[V+1]; //���� �����
			boolean[] visited = new boolean[V+1]; // �湮�ߴ��� Ȯ��
			
			//graph �ʱ�ȭ
			for(int i = 1; i <= E; i++) {
				int e1 = sc.nextInt();
				int e2 = sc.nextInt();
					
				graph[e1][e2]=graph[e2][e1]=1;
				
				degree[e1]++; // ���� �� üũ
				degree[e2]++; // ���� �� üũ
			}
			
			int total = V;
			int sum = 0;
			
			for(int i=1 ; i <= V; i++) {
				//���� �� �� K ���� ������ �� ���� .
				if(!visited[i] && (degree[i] < K || degree[i] > (total-L-1))) {
					for(int j = 1 ; j <= V ; j++) {
						degree[j] = degree[j] - graph[j][i];
						graph[j][i] = graph[i][j] = 0;
					}
					visited[i] = true;
					total--;
					sum += i;
					i=0;
				}
			}
			
			// �� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("Case #" + test_case);
			System.out.println(sum);
		}
		
		sc.close();
	}
}