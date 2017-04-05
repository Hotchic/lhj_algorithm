import java.util.Scanner;

public class Main {
	static int[][] 		map;
	static boolean[] 	visited;
	static int			cnt=0;
	static int 			nV, nE;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		nV = scan.nextInt();
		nE = scan.nextInt();
		
		map = new int[nV+1][nV+1];
		visited = new boolean[nV+1];
		
		for(int i = 0; i<nE ;i++) {
			int vt1 = scan.nextInt();
			int vt2 = scan.nextInt();
			
			map[vt1][vt2] = map[vt2][vt1] = 1;
		}
		
		dfs(1);
		
		System.out.println(cnt);
	}
	
	public static void dfs(int start) {
		visited[start] = true;
		
		for(int i = 1; i <= nV ; i++) {
			if(map[start][i] == 1 && visited[i] == false) {
				cnt++;
				dfs(i);
			}
		}
	}
}
