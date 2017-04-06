package chess;

import java.util.Arrays;
import java.util.Scanner;

class Pos implements Comparable<Pos> {
	int x;
	int y;
	Pos(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Pos o) {
		// Pos 객체 배열 정렬을 위한 compareTo 메소드 재정의
		if(x > o.x) return 1;
		else if(x < o.x) return -1;
		else {
			if(y > o.y) return 1;
			else if(y < o.y) return -1;
			else return 0;
		}
	}
	
}

public class Solution {
	static int[] factorial= new int[200001];
	static int[] factorialInverse= new int[200001];
	
	public static int combination(int a, int b) {
		long e = factorial[a];
		e = (e*factorialInverse[b]) % 100000007;
		e = (e*factorialInverse[a-b]) % 1000000007;
		
		return (int)e;
	}
	public static void init() {
		long factorial1 = 1;
		factorial[0] = 1;
		for(int i = 1; i < 200001 ; i++) {
			factorial1 = (factorial1*i) % 1000000007;
			factorial[i] = (int) factorial1;
		}
		long inversefactorial1 = inversefactorial((int)factorial1);
		for(int i = 200000; i>=0; i--) {
			factorialInverse[i] = (int)inversefactorial1;
			inversefactorial1 = (inversefactorial1*i) % 1000000007;
		}
	}
	public static int inversefactorial(int x) {
		return mod(x,1000000005);
	}
	// x^k mod 1000000007을 계산해주는 함수.
	public static int mod(int x, int k){
		if(k==1)
			return x;
		int t = mod(x,k/2);
		long result = t;
		result = (result * t) %1000000007;
		// 홀수인 경우 x 한번 더 곱해야함.
		if(k % 2 == 1){
			result = (result * x) %1000000007;
		}
		return (int) result;
	}

	public static void main(String[] args) throws Exception {
		// TODO 자동 생성된 메소드 스텁
		Scanner sc = new Scanner(System.in);

		int TC;
		int test_case;
		init();
		TC = sc.nextInt();        
		for(test_case = 1; test_case <= TC; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			
			//장애물 위치 받기.
			Pos[] pos = new Pos[k+1];
			
			for(int i = 0 ; i < k ;i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				pos[i] = new Pos(x,y);
			}
			//마지막 장애물 위치 입력
			Pos finalPos = new Pos(n,m);
			pos[k] = finalPos;
			
			// 위치값 정렬.
			Arrays.sort(pos);
			//도착점 인덱스 찾기
			int index = Arrays.binarySearch(pos, finalPos);
			int[] path = new int[index+1];
					
			for(int i = 0; i<index+1 ; i++) {
				long otherpath = 0;
				
				if(pos[i].x > n || pos[i].y >m) continue;
				
				for(int j=0;j<i;j++) {
					if(pos[j].y <= pos[i].y && pos[j].x <= pos[i].x) {
						long temp = path[j];
						
						temp = (temp* combination(pos[i].x-pos[j].x+pos[i].y-pos[j].y,pos[i].y-pos[j].y)) % 1000000007;
						otherpath = (otherpath+temp) % 1000000007;
					}
				}
				int totalPath = combination(pos[i].x+pos[i].y-2,pos[i].x-1);
				totalPath -= (int)otherpath;
				totalPath = (1000000007 + totalPath) % 1000000007;
				path[i] = totalPath;
			}
			
			
			
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(path[index]);
		}
	}

}
