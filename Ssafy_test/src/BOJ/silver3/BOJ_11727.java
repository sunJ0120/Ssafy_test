package BOJ.silver3;

import java.io.*;

public class BOJ_11727 {
	
	static int dp[];
	
	public static int DP(int n) {
		
		if(dp[n] != 0) {
			return dp[n]; //있으면 내보낸다.
		}
		
		if(n <= 0) {
			return 0;
		}
		
		dp[n] = DP(n-1)%10007 + 2*DP(n-2)%10007;
		
		return dp[n];
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		dp = new int[num+2];
		
		dp[1] = 1;
		dp[2] = 3;
		
		if(num <= 2) {
			bw.write(dp[num] + "\n");
		}else {
			bw.write(DP(num)%10007 + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
