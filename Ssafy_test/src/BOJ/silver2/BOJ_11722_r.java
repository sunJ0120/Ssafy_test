package BOJ.silver2;

import java.io.*;
import java.util.*;

public class BOJ_11722_r {
	static int[] ll;
	static int[] dp;
	
	public static int DP(int n) {
		
		if(dp[n] != 0) {
			return dp[n];
		}
		
		if(n == 0) {
			return 0;
		}
		
		int max = 0;
		for(int i = n-1; i>=0; i--) {
			if(ll[n] < ll[i]) {
				max = Math.max(max, DP(i));
			}
		}
		dp[n] = max + 1;
		
		return 1;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		ll = new int[num];
		dp = new int[num];
		int ans = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<num; i++) {
			ll[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = 1;
		
		for(int i = 1; i<num; i++){
			DP(i);
		}
		
		for(int i = 0; i<num; i++) {
			ans = Math.max(ans, dp[i]);
		}
		
		bw.write(ans + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
