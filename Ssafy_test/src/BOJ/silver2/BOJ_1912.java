package BOJ.silver2;

import java.io.*;
import java.util.*;

public class BOJ_1912 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		int[] dp = new int[num];
		int[] ll = new int[num];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<num; i++) {
			ll[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = ll[0]; //초기화
		
		for(int i = 1; i<num;i++) {
			dp[i] = ll[i] + Math.max(0, dp[i-1]);
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i<num; i++) {
			max = Math.max(max, dp[i]); //dp[i] 수열에서 최소값 구하기
		}
		
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
