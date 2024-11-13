package BOJ.silver2;

import java.util.*;
import java.io.*;

public class BOJ_11048 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] ll = new int[n][m];
		int[][] dp = new int[n][m];
		
		//초기값 저장
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				ll[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//초기화
		dp[0][0] = ll[0][0];
				
		for(int i = 1; i<n; i++) {
			dp[i][0] = dp[i-1][0] + ll[i][0];
		}
		
		for(int i = 1; i<m; i++) {
			dp[0][i] = dp[0][i-1] + ll[0][i];
		}
		
		for(int i = 1; i<n; i++) {
			for(int j = 1; j<m; j++) {
				dp[i][j] = ll[i][j] + Math.max(Math.max(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
			}
		}
		
		bw.write(dp[n-1][m-1] + "\n");
		bw.flush();
		br.close();
		bw.close();

	}
}
