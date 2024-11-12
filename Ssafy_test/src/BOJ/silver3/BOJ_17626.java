package BOJ.silver3;

import java.io.*;
import java.util.*;

public class BOJ_17626 {
	
	static int[] dp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		dp = new int[num+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		dp[0] = 0; //return 0 하듯이 초기값이 필요하다.
		
		//dp에서 top -> 올라가는 부분만 반복문으로 구현이 가능하다!
		//이를 이용해서 시간을 줄일 수 있음
		for(int i = 1; i<=num; i++) {
			for(int j = 1; j*j<= i; j++) {
				dp[i] = Math.min(dp[i], dp[i-j*j]+1);
			}
		}
		
		bw.write(dp[num] + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
