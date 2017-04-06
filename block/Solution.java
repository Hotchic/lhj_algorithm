package block;
import java.util.Scanner;
import java.util.Arrays;

class Solution {
	public static void main(String args[]) throws Exception {
		new Solution ().solve();
	}
	
	public void solve(){
		// 팩토리얼 관련 값 초기화.
		init();
		
		int T;
		int test_case;
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			Point[] points = new Point[k+1];
			
			// point 객체로 저장할 것.
			for (int i = 0; i < k; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				points[i] = new Point(a,b);
			}
			
			// 마지막 point 추가.
			Point finalPoint = new Point(n,m);
			points[k] = finalPoint;
			
			// point 정렬.
			Arrays.sort(points);
			
			// 최종 point의 위치 파악.
			int index = Arrays.binarySearch(points, finalPoint);
			
			// 각 point들까지의 경로 갯수를 찾을 것인데
			// 이전에 다른 point들을 지나가는 경로는 배제.
			// 다른 point들이란 points안의 자신을 제외한 다른 점.
			
			// 즉, 경로가 거치는 최초의 point가 i인 경우만
			// i까지의 경로로 침.
			
			int[] pathNumber = new int[index+1];
			
			//for(int i=0; i<index+1; i++)
				//pathNumber[i] = -1;
			
			for(int i=0; i<index+1; i++){
				// 중간에 다른 point을 지나는 경로 갯수 세서 빼줄거임.
				long otherPointPathNumber = 0;
				
				// 유효하지 않은 범위면 그냥 통과.
				if(points[i].y>m || points[i].x >n)
					continue;
				
				// 거쳐갈 가능성이 있는 모든 point j들을 조사.
				// 이 점들은 배열 상에서 반드시 자신보다 앞에 있어야 함. 
				// 이 점은 x, y값이 자신의 x,y보다 작아야함.
				// x값을 기준으로 정렬했으므로 일단 x값이 자신보다 작은 점들은 전부 배열 상에서 자신보다 앞에 있음.
				// 따라서 앞에 있는 모든 점들만 조사해보면 됨.
				for(int j=0; j<i; j++){
					if(points[j].y <= points[i].y && points[j].x <= points[i].x){
						
						// point j 까지 경로 갯수
						long temp = pathNumber[j];
						
						// point i와 j를 동시에 거치는 경로 수 = point j 까지 경로 갯수 *point j에서 i까지 경로 갯수 
						temp = (temp * combination(points[i].x - points[j].x + points[i].y - points[j].y, points[i].y - points[j].y)) % 1000000007;
						
						// 중복 발생 불가하므로 그냥 전부 더하면 됨
						
						// 그러니까
						//  start -> point j -> point i
						//  start -> point j' -> point i
						// 이 두 경로는 절대로 겹치지 않는다.
						
						// 만약 겹친다면 
						// start -> point j ->  point j'
						// start -> point j' ->  point j
						// 꼴의 경로를 포함해야하는데
						// j, j' 까지의 경로 수를 계산할 때 이런 경로는 이미 배제되었음.
						// 경로가 거치는 최초의 point가 x인 경우만 x까지의 경로로 치고 있기 때문.
						
						otherPointPathNumber = (otherPointPathNumber + temp) % 1000000007;
					}
				}
				
				// 중간에 다른 point가 없을 경우(x1 + y1 - 2) C (x1 - 1) 임.
				// 여기서 위에서 계산한 다른 point들을 거쳐가는 경로를 빼주기.
				int totalPath =  combination(points[i].x + points[i].y - 2, points[i].x - 1);
				totalPath -= (int)otherPointPathNumber;
				totalPath = (1000000007 + totalPath) % 1000000007;
				
				pathNumber[i] = totalPath;
			}
			
			System.out.println("Case #" + test_case);
			System.out.println(pathNumber[index]);
		}
	}
	
	public static int combination(int a, int b){
		long e= factorial[a];
		e = (e*factorialInverse[b]) % 1000000007;
		e = (e*factorialInverse[a-b]) % 1000000007;
		return (int)e;
	}
	
	static int[] factorial= new int[200001];
	static int[] factorialInverse= new int[200001];
	
	// 팩토리얼 및 역수 값 전부 계산해두기.
	public static void init(){
		long o = 1;
		factorial[0] = 1;
		for(int i=1; i<200001; i++){
			o = (o*i) % 1000000007;
			factorial[i] = (int) o;
		}
		long oi = inversefactorial((int)o);
		for(int i=200000; i>=0; i--){
			factorialInverse[i] = (int)oi;
			oi = (oi * i) % 1000000007;
		}
	}
	
	public static int inversefactorial(int x){
		return power(x, 1000000005);
	}
	
	public static int power(int x, int p){
		if(p==1)
			return x;
		int t = power(x,p/2);
		long result = t;
		result = (result * t) %1000000007;
		if(p % 2 == 1 ){
			result = (result * x) %1000000007;
		}
		return (int) result;
	}
	
	class Point implements Comparable<Point>{
		int x;
		int y;
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Point o) {
			if(x>o.x)
				return 1;
			else if(x<o.x)
				return -1;
			else{
				if(y>o.y)
					return 1;
				else if(y<o.y)
					return -1;
				else
					return 0;
			}
		}
	}
}