
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고,
 * 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 
 * 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 
 * 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
 * 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 
 * 몇 초 후인지 구하는 프로그램을 작성하시오.
 */
public class Main {
	public static final int MAX = 1000000;
	public static boolean[] check;
	public static int[] dist;
	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		check = new boolean[MAX];
		dist = new int[MAX];
		
		dist[N] = 0;
		
		bfs(N);
		
		System.out.println(dist[K]);
	}

	public static void bfs(int start){
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		check[start] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			if( now-1 >=0) {
				if( check[now-1] == false) {
					q.offer(now-1);
					check[now-1] = true;
					dist[now-1] = dist[now] + 1;
				}
			}
			if( now+1 < MAX) {	
				if( check[now+1] == false) {
					q.offer(now+1);
					check[now+1] = true;
					dist[now+1] = dist[now] + 1;
				}
			}
			if( now*2 < MAX) {	
				if( check[now*2] == false) {
					q.offer(now*2);
					check[now*2] = true;
					dist[now*2] = dist[now] + 1;
				}
			}
		}
	}


}
