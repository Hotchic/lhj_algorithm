package virus;
import java.util.Scanner;

/**
 * [코드그라운드] - 바이러스 대책[SCPC 2016 - 1차 예선]
 * 
 * **/

class Solution {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();        
		for(test_case = 1; test_case <= T; test_case++) {
			
			int K = sc.nextInt(); //각 정점의 차수
			int L = sc.nextInt(); //감염되어도 살아남는 최소 로봇 수 
			int V = sc.nextInt(); //정점
			int E = sc.nextInt(); //간선
			
			int[][] graph = new int[V+1][V+1]; // 그래프 
			int[] degree = new int[V+1]; //차수 저장용
			boolean[] visited = new boolean[V+1]; // 방문했는지 확인
			
			//graph 초기화
			for(int i = 1; i <= E; i++) {
				int e1 = sc.nextInt();
				int e2 = sc.nextInt();
					
				graph[e1][e2]=graph[e2][e1]=1;
				
				degree[e1]++; // 간선 수 체크
				degree[e2]++; // 간선 수 체크
			}
			
			int total = V;
			int sum = 0;
			
			for(int i=1 ; i <= V; i++) {
				//간선 수 가 K 보다 낮은거 다 제거 .
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
			
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(sum);
		}
		
		sc.close();
	}
}