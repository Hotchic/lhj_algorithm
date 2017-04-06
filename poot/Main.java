package poot;


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
	static int[][] 		map; 
	static int[][] 		visited;
	static int 			nV; // Vertex 수
	static int[]		cX = {0,0,-1,1}; // X좌표 확인
	static int[]		cY = {1,-1,0,0}; // Y좌표 확인
	static int 			housing;
	static int[]		cnt;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		nV = scan.nextInt();
		
		map = new int[nV][nV];
		visited = new int[nV][nV];
		cnt = new int[25*25+1];
		
		for(int i = 0;i<nV ;i++) {
			String tmp = scan.next();
			for(int j = 0;j<tmp.length();j++) {
				map[i][j] = Integer.parseInt(tmp.substring(j, j+1));
//				map[i][j] = tmp.charAt(j)-'0';
			}

			
		}
		
		housing = 0;
		
		for(int i = 0;i<map.length ;i++) {
			for(int j = 0; j<map[i].length;j++) {
				if(map[i][j] == 1 && visited[i][j] == 0){
					bfs(i,j,++housing);
				}
					
			}
		}

		System.out.println(housing);
		Arrays.sort(cnt);
		for(int i = (cnt.length-housing) ; i < cnt.length; i++) {
			System.out.println(cnt[i]);
		}
		scan.close();
		
	}
	
	public static void bfs(int nX, int nY,int house) {
		Queue<Pos> q = new LinkedList<Pos>();
		visited[nX][nY] = house;
		q.offer(new Pos(nX,nY));

		while(!q.isEmpty()) {
			Pos temp = q.poll();
			cnt[house]++;
			for(int i = 0; i < 4; i++) {
				int nextX = cX[i] + temp.x;
				int nextY = cY[i] + temp.y;
				
				if(nextX > -1 && nextX < nV && nextY > -1 && nextY < nV &&map[nextX][nextY] == 1 && visited[nextX][nextY] == 0) {
					
					q.offer(new Pos(nextX,nextY));
					visited[nextX][nextY] = house;
				}
			}
		}

	}
}
