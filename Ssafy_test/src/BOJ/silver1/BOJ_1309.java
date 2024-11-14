package BOJ.silver1;

import java.io.*;

public class BOJ_1309 {
	
	static int[][] dp;
	static int n;
	
	public static int DP(int i, int j) {
		if(dp[i][j] != 0) {
			return dp[i][j];
		}
		
		if(j == 0) {
			dp[i][j] = DP(i+1,1)%9901 + DP(i+1,2)%9901;
		}else if(j == 1) {
			dp[i][j] = DP(i+1,0)%9901 + DP(i+1,2)%9901;
		}else { //j == 2
			dp[i][j] = DP(i+1,0)%9901 + DP(i+1,1)%9901 + DP(i+1,2)%9901;
		}
		
		return dp[i][j];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		dp = new int[n][3]; //0번째, 1번째 2번째(아무것도 놓지 않을 때)
		
		dp[n-1][0] = 1;
		dp[n-1][1] = 1;
		dp[n-1][2] = 1;
		
		int sum = 0;
		
		for(int j = n-2; j>=0; j--) {
			for(int i = 0; i<3; i++){
				if(i == 0) {
					dp[j][i] = dp[j+1][1]%9901 + dp[j+1][2]%9901;
				}else if(i == 1) {
					dp[j][i] = dp[j+1][0]%9901 + dp[j+1][2]%9901;
				}else { //i == 2
					dp[j][i] = dp[j+1][0]%9901 + dp[j+1][1]%9901 + dp[j+1][2]%9901;
				}
			}
		}
		
		sum = (dp[0][0]%9901 + dp[0][1]%9901 + dp[0][2]%9901)%9901;
		
		bw.write(sum + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
