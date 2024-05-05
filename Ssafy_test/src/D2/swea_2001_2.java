package D2;

import java.util.Scanner;

public class swea_2001_2 {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int num = sc.nextInt();
		StringBuilder stb = new StringBuilder();
		
		for(int z = 1; z<=num; z++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] fly = new int[n+1][n+1];
			int[][] dp = new int[n+1][n+1];
			int max = 0;
			
			for(int i = 0; i<=n; i++) {
				for(int j = 0; j<=n;j++) {
					
					if(i==0 || j == 0) {
						fly[i][j] = 0;
						continue;
					}
					
					fly[i][j] = sc.nextInt();
					
				}
			}
			
			for(int i = 1; i<=n; i++) {
				for(int j = 1; j<=n;j++) {
					dp[i][j] = fly[i][j] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
				}
			}
			
			int icheck = m;
			int jcheck = m;
			
			for(int i = 0; i<=n-m; i++) {
				//m씩 뛰어넘기
				for(int j = 0; j<=n-m;j++) {
					int dpp = dp[i][j] - dp[icheck][j] - dp[i][jcheck] + dp[icheck][jcheck];
					if(dpp > max) {
						max = dpp;
					}
					jcheck++;
				}
				icheck++;
				jcheck = m; //초기화
			}
			
			stb.append("#");
			stb.append(z+" ");
			stb.append(max);
			stb.append("\n");
		}
		System.out.println(stb);
	}

}
