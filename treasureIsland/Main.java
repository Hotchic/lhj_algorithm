package treasureIsland;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pos {
	int x;
	int y;
	Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static char[][] 	map;
	static int[][]		visited;
	static int			x,y;
	static int[]		cX = {0,0,-1,1};
	static int[]		cY = {1,-1,0,0};
	static int[]		cnt;
	static int 			labling;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		y = scan.nextInt();
		x = scan.nextInt();

		map = new char[y][x];
		visited = new int[y][x];
		cnt = new int[y*x+1];
		
		for(int i = 0; i < y;i++) {
			String s = scan.next();
			for(int j = 0;j<s.length();j++) {
				map[i][j] =s.charAt(j);
			}
		}
		
		
		for(int i = 0 ; i < map.length;i++) {
			for(int j = 0 ; j < map[i].length ; j++) {
				if(map[i][j] == 'L' && visited[i][j] == 0) {
					labling = 0;
					bfs(i,j);
				}
			}
		}
		for(int i = 0 ; i < map.length;i++) {
			for(int j = 0 ; j < map[i].length ; j++) {
				System.out.print(visited[i][j]);
			}
			System.out.println();
		}
		Arrays.sort(cnt);

		System.out.println(cnt[x*y]);
	}
	
	public static void bfs(int nY, int nX) {
		Queue<Pos> q = new LinkedList<Pos>();
		q.offer(new Pos(nY,nX));

		
		while(!q.isEmpty()) {
			Pos temp = q.poll();
			labling++;
			visited[nY][nX] = labling;
			
			for(int i = 0 ; i < 4; i++) {
				int nextX = cX[i] + temp.x;
				int nextY = cY[i] + temp.y;
				
				if(nextX > -1 && nextX < y && nextY > -1 && nextY < x && map[nextX][nextY] == 'L' && visited[nextX][nextY] == 0) {
					q.offer(new Pos(nextX,nextY));
					visited[nextX][nextY] = labling+1;
				}
			}
		}
		
	}

}
