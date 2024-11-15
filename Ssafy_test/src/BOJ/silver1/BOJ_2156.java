package BOJ.silver1;

import java.io.*;

public class BOJ_2156 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		int[] ll = new int[num+1]; //num 넘치는 부분은, 3일때 0으로 계산하기 위해 남겨둠
		int[] dp = new int[num+1];
		int ans = 0;
		
		for(int i = 0; i<num; i++) {
			ll[i] = Integer.parseInt(br.readLine());
		}
		
		//초기값
		dp[num-1] = ll[num-1];
		
		if(num>=2) {
			dp[num-2] = ll[num-2] + ll[num-1]; //초기화
			for(int i = num-3; i>=0; i--) {
				dp[i] = Math.max(ll[i]+ ll[i+1] + dp[i+3], Math.max(dp[i+1],ll[i] + dp[i+2]));
			}
		}
		
		bw.write(dp[0] + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
