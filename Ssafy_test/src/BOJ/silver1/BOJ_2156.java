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
				//dp[i+3] 부터 max
				int a = 0;
				for(int j = i+3; j< num; j++) {
					a = Math.max(a, dp[j]);
				}
				
				//dp[i+2] 부터 max
				int b = 0;
				for(int j = i+2; j< num; j++) {
					b = Math.max(b, dp[j]);
				}
				
				dp[i] = ll[i] + Math.max(ll[i+1] + a, b);
			}
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
