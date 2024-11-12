package BOJ.silver3;

import java.io.*;
import java.util.*;

public class BOJ_9095 {
	static int dpList[];
	
	public static int dp(int n) {
		if(n <= 0) {
			return 0; //0으로 처리하고 끝내기
		}
		
		if(dpList[n] == 0) { //내부에 없음
			dpList[n] = dp(n-3) + dp(n-2) + dp(n-1);
		}
		
		return dpList[n];
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<num; i++) {
			int n = Integer.parseInt(br.readLine());
			dpList = new int[n+3];
			
			//초기점
			dpList[1] = 1;
			dpList[2] = 2;
			dpList[3] = 4;
			
			bw.write(dp(n) + "\n");
			Arrays.fill(dpList, 0); //초기화
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
