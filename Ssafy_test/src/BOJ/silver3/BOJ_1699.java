package BOJ.silver3;

import java.io.*;
import java.util.*;

public class BOJ_1699 {
	
	static int dpList[];
	
	public static int dp(int n) {
		
		if(dpList[n] != -1) { //이미 있음
			return dpList[n];
		}
		
		if(n == 0) {
			return 0;
		}
		
		int minCount = Integer.MAX_VALUE;
		
		for(int i = 1; i*i<=n; i++) {
			int num = i*i;
			minCount = Math.min(dp(n - num) + 1, minCount);
		}
		
		dpList[n] = minCount; //모든 재귀 과정을 끝낸 후 minCount를 저장한다.
		return dpList[n];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		dpList = new int[num+1];
		
		Arrays.fill(dpList, -1);
		
		bw.write(dp(num) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
