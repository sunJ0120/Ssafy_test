package BOJ.silver1;

import java.util.*;
import java.io.*;

public class BOJ_1149 {
	static int iNum;
	static int[][] dp;
	static int[][] ll;
	
	public static int DP(int i, int j) {
		if(dp[i][j] != 0) { //저장된 수가 있음
			return dp[i][j];
		}
		
		int m = 0;
		
		if(j == 0) {
			m = Math.min(DP(i+1,1), DP(i+1,2));
		}else if(j == 1) {
			m = Math.min(DP(i+1,0), DP(i+1,2));
		}else { //j == 2
			m = Math.min(DP(i+1,0), DP(i+1,1));
		}
		
		dp[i][j] = m + ll[i][j];
		
		return dp[i][j];
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		iNum = Integer.parseInt(br.readLine());
		dp = new int[iNum][3];
		ll = new int[iNum][3];
		
		for(int i = 0; i<iNum; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<3; j++) {
				ll[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//초기화
		dp[iNum-1][0] = ll[iNum-1][0];
		dp[iNum-1][1] = ll[iNum-1][1];
		dp[iNum-1][2] = ll[iNum-1][2];
		
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i<3; i++) {
			ans = Math.min(ans,DP(0, i));
		}
		
		bw.write(ans + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
