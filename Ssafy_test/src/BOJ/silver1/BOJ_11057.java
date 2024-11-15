package BOJ.silver1;

import java.io.*;
import java.util.*;

public class BOJ_11057 {
	static int num;
	static int[][] dp;
	
	public static int DP(int dept, int num) {
		if(dp[dept][num] != 0) {
			return dp[dept][num];
		}
		
		for(int i = num; i<10; i++) {
			dp[dept][num] += DP(dept-1,i)%10007;
			dp[dept][num] %= 10007; 
		}
		
		return dp[dept][num]%10007;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		num = Integer.parseInt(br.readLine());
		dp = new int[num][10]; //dept, n
		
		int ans = 0;
		
		//초기화
		for(int i = 0; i<10; i++) {
			dp[0][i] = 1;
		}
		
		for(int i = 0; i<10; i++) {
			ans += DP(num-1, i);
			ans%=10007;
		}
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
