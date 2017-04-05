package bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class BfsMain {
	static int vertex;
	static int startVertex;
	static int[][] vertexMap;
	static boolean[] vertexVisit;
	
	public static void bfs(int i) {
		Queue<Integer> q = new <Integer> LinkedList();
		HashMap <Integer, Boolean> hash = new HashMap<Integer, Boolean>();
	
		q.offer(i);

		while(!q.isEmpty()) {
			int temp = q.poll();
			vertexVisit[temp] = true;
			System.out.println(temp);
			
			for(int j = 1; j<= vertex ; j++) {
				if(vertexMap[temp][j] == 1 && vertexVisit[j] == false) {
					if(!hash.containsKey(j)){
						q.offer(j);
						hash.put(j, true);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		vertex = scan.nextInt();
		startVertex = Integer.parseInt(scan.nextLine().trim());
		
		vertexMap = new int[vertex+1][vertex+1];
		vertexVisit = new boolean[vertex+1];
		
		while(true) {
			int vt1, vt2;
			vt1 = scan.nextInt();
			vt2 = scan.nextInt();
			
			if(vt1 < 0 && vt2 < 0) break;
			
			vertexMap[vt1][vt2] = vertexMap[vt2][vt1] = 1;
		}
		
		bfs(startVertex);
	}
	
	

}
