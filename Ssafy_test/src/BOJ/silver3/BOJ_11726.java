package BOJ.silver3;

import java.io.*;

public class BOJ_11726 {
	
	static int[] dpList;
	
	public static int dp(int n) {
		if(n <= 0) {
			return 0;
		}
		
		if(dpList[n] == 0) {
			dpList[n] = dp(n-1) + dp(n-2);
		}
		
		return dpList[n] % 10007;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		dpList = new int[num + 2];
		
		dpList[1] = 1;
		dpList[2] = 2;
		
		if(num <= 2) {
			bw.write(dpList[num] + "\n");
		}else {
			bw.write(dp(num)% 10007 + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
