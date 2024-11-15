package BOJ.silver1;

import java.io.*;

public class BOJ_10844 {
	static int n;
	static int[][] dp;
	
	public static int DP(int dept, int num) {
		
		if(dp[dept][num] != 0) {
			return dp[dept][num]%1000000000;
		}
		
		if(num == 0) {
			dp[dept][num] = DP(dept-1, num+1)%1000000000;
		}else if(num == 9) {
			dp[dept][num] = DP(dept-1, num-1)%1000000000;
		}else{
			dp[dept][num] = DP(dept-1, num-1)%1000000000 + DP(dept-1, num+1)%1000000000;
		}
		
		return dp[dept][num]%1000000000;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		dp = new int[n][10];
		
		//초기화
		for(int i = 0; i<10; i++) {
			dp[0][i] = 1;
		}
		
		int ans = 0;
		
		for(int i = 1; i<10; i++) {
			ans += DP(n-1,i);
			ans%=1000000000;
		}
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
