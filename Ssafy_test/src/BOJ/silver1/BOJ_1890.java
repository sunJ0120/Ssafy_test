package BOJ.silver1;

import java.io.*;
import java.util.*;

public class BOJ_1890 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		long[][] dp = new long[num][num];
		long[][] ll = new long[num][num];
		
		for(int i = 0; i<num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<num; j++) {
				ll[i][j] = Long.parseLong(st.nextToken());
			}
		}
		
		//초기화
		dp[num-1][num-1] = 1;
		
		for(int i = num-1; i>=0; i--) {
			//가로 체크
			if(i == num-1) {
				for(int j = num-2; j>=0; j--) {
					if(j + ll[i][j] <= num-1 && dp[i][j + (int)ll[i][j]] == 1) {
						dp[i][j] = 1;
					}
				}
			}else { //세로 체크
				if(i+ll[i][num-1] <= num-1 && dp[i+(int)ll[i][num-1]][num-1] == 1) {
					dp[i][num-1] = 1;
				}
			}
		}
		
		for(int i = num-2; i>= 0; i--) {
			for(int j = num-2; j>=0; j--) {
				if(j+ll[i][j] <= num-1) { //범위 내에 있어야 하므로, 
					dp[i][j] += dp[i][j + (int)ll[i][j]];
				}
				if(i+ll[i][j] <= num-1) {
					dp[i][j] += dp[i+(int)ll[i][j]][j];
				}
			}
		}
		
		bw.write(dp[0][0] + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
