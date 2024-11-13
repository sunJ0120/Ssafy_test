package BOJ.silver2;

import java.util.*;
import java.io.*;

public class BOJ_11055_r {
	
	static int[] dp;
	static int[] ll;
	
	public static int DP(int n) {
		if(dp[n] != 0) { //안에 저장된 값이 있음
			return dp[n];
		}
		if(n == 0) {
			return 0;
		}
		
		int max = 0;
		for(int i = n-1;i>=0; i--) {
			if(ll[i] < ll[n]) {
				max = Math.max(DP(i), max);
			}
		}
		
		dp[n] = max + ll[n];
		
		return 1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		dp = new int[num];
		ll = new int[num];
		
		int ans = 0;
		
		for(int i = 0; i<num; i++) {
			ll[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = ll[0]; //초기화
				
		for(int i = 1; i<num; i++) {
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
