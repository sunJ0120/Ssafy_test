package D2;

import java.util.Scanner;

/*
 * 파리채 문제
 * n m이 주어진다.
 * m을 배열로 두고, n을 계속 움직이면서 계산하는게 좋을 것 같음
 * greedy 문제..?
 */

public class swea_2001 {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int num = sc.nextInt();
		StringBuilder stb = new StringBuilder();
		
		for(int z = 1; z<=num; z++) {
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int iEnd = m;
			int iStart = 0;
			
			int jEnd = m;
			int jStart = 0;
			int ans = 0;
			
			int[][] fly = new int[n][n];
			
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					fly[i][j] = sc.nextInt();
				}
			}
			
			while(iEnd <= n) {
				while(jEnd <= n) {
					int max = 0;
					for(int i = iStart; i< iEnd; i++) {
						for(int j = jStart; j< jEnd; j++) {
							max += fly[i][j];
						}
					}
					if(max > ans) {
						ans = max;
					}
					jStart++;
					jEnd++;
				}
				iStart++;
				iEnd++;
				
				jStart = 0; //초기화
				jEnd = m;
			}
			
			stb.append("#" + z + " " + ans);
			stb.append("\n");
		}
		System.out.println(stb);
	}

}
