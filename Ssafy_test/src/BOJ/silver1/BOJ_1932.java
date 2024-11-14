package BOJ.silver1;

import java.io.*;
import java.util.*;

public class BOJ_1932 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[num][num];
		int[][] ll = new int[num][num];
		
		for(int i = 0; i<num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<=i; j++) {
				ll[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//초기 끝값 저장
		for(int i = 0; i<num; i++) {
			dp[num-1][i] = ll[num-1][i];
		}
		
		for(int i = num-2; i>=0; i--) {
			for(int j = 0; j<=i; j++) {
				dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1]) + ll[i][j];
			}
		}
		
		bw.write(dp[0][0] + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
