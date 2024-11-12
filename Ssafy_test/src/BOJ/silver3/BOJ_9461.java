package BOJ.silver3;

import java.io.*;
import java.util.*;

public class BOJ_9461 {

	static long[] dpList;
	
	public static long dp(int n) {
		if(n<0) {
			return 0;
		}
		
		if(dpList[n] == 0) {
			dpList[n] = dp(n-1) + dp(n-5);
		}
		
		return dpList[n];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());

		for(int i = 0; i<num; i++) {
			int n = Integer.parseInt(br.readLine());
			dpList = new long[n+4];
			
			dpList[0] = 0;
			dpList[1] = 1;
			dpList[2] = 1;
			dpList[3] = 1;
			dpList[4] = 2;
			
			if(n < 5) {
				bw.write(dpList[n] + "\n");
			}else {
				bw.write(dp(n) + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		bw.close();
	}
}
