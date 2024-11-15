package BOJ.silver1;

import java.io.*;
import java.util.*;

public class BOJ_9465 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		for(int z = 0; z<num; z++) {
			int n = Integer.parseInt(br.readLine());
			int[][] ll = new int[2][n];
			int[][] dp = new int[2][n];
			
			int ans = 0;
			
			for(int i = 0; i<2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<n; j++) {
					ll[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//초기화
			dp[0][n-1] = ll[0][n-1];
			dp[1][n-1] = ll[1][n-1];
			
			if(n>=2) {
				dp[0][n-2] = ll[0][n-2] + ll[1][n-1];
				dp[1][n-2] = ll[1][n-2] + ll[0][n-1];
				
				for(int j = n-3; j>=0; j--) {
					for(int i = 0; i<2; i++) {
						int m = Math.max(dp[0][j+2], dp[1][j+2]);
						
						if(i == 0) {
							dp[i][j] = Math.max(ll[i][j] + Math.max(dp[1][j+1], m), dp[0][j+1]);
						}else { //i == 1
							dp[i][j] = Math.max(ll[i][j] + Math.max(dp[0][j+1], m), dp[1][j+1]);
						}
					}
				}
			}
			bw.write(Math.max(dp[1][0], dp[0][0]) + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
