/**
 * 강남역에서 붕어빵 장사를 하고 있는 해빈이는 지금 붕어빵이 N개 남았다.

해빈이는 적절히 붕어빵 세트 메뉴를 구성해서 붕어빵을 팔아서 얻을 수 있는 수익을 최대로 만드려고 한다. 붕어빵 세트 메뉴는 붕어빵을 묶어서 파는 것을 의미하고, 세트 메뉴의 가격은 이미 정해져 있다.

붕어빵 i개로 이루어진 세트 메뉴의 가격은 Pi 원이다.

붕어빵이 4개 남아 있고, 1개 팔 때의 가격이 1, 2개는 5, 3개는 6, 4개는 7인 경우에 해빈이가 얻을 수 있는 최대 수익은 10원이다. 2개, 2개로 붕어빵을 팔면 되기 때문이다.

1개 팔 때의 가격이 5, 2개는 2, 3개는 8, 4개는 10 인 경우에는 20이 된다. 1개, 1개, 1개, 1개로 붕어빵을 팔면 되기 때문이다.

마지막으로, 1개 팔 때의 가격이 3, 2개는 5, 3개는 15, 4개는 16인 경우에는 정답은 18이다. 붕어빵을 3개, 1개로 팔면 되기 때문이다.

세트 메뉴의 가격이 주어졌을 때, 해빈이가 얻을 수 있는 최대 수익을 구하는 프로그램을 작성하시오.
 * */

package dp;

import java.util.Scanner;

public class Boong {
	static int[] d ;
	static int[] p ;
	
	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		d = new int[N+1];
		p = new int[N+1];
		
		for(int i = 1; i<= N;i++) {
			int P = sc.nextInt();
			
			p[i] = P;
		}
		
		for(int i = 1; i <= N ; i++) {
			for(int j = 1 ; j <= i; j++) {
				d[i] = max(d[i],d[i-j]+p[j]);
			}
		}
		
		System.out.println(d[N]);
	}
	
	public static int max(int max, int temp) {
		if(max < temp) 
			return temp;
		else return max;
	}

}
