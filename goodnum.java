import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception	{
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));
        
		Scanner sc = new Scanner(System.in);

		int TC;
		int test_case;

		TC = sc.nextInt();        
		for(test_case = 1; test_case <= TC; test_case++) {
			// �� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�.
			int n = sc.nextInt();
			int[] a = new int[n];

			int cnt = 0;
        	boolean[] b = new boolean[400001];			
			for(int i = 0; i<n;i++) {
				a[i] = sc.nextInt();

			}

			for(int i = 0; i < n; i++) {
				boolean found = false;
                
				for(int j= 0; j < i && !found;j++) {
					if(b[a[i]-a[j] + 200000] == true) {
						found = true;
					}
				}
				for(int j=0; j<=i;j++) {
					b[200000+a[i]+a[j]] = true;
                }
				if(found) cnt++;
			}

			// �� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("Case #" + test_case);
			System.out.println(cnt);
		}
	}
}