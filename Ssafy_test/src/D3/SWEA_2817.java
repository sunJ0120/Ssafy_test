package D3;

import java.util.*;
import java.io.*;

public class SWEA_2817 {
	static int[] ll;
	static int[] l;
	static int n;
	static int ans;
	static int start;
	
	public static void dp(int t, int k) {
		
		if(t >= n) { //종료조건
			return;
		}
		
		if(l[t] == 0) { //값이 없음
			l[t] = l[t-1] + ll[t];
		}
		
		if(l[t] == k) {
			ans++;
			dp(t+1, k);
		}else if(l[t] > k) {
			l[t] -= ll[start];
			start++;
			dp(t, k);
		}else {
			dp(t+1, k);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		for(int g = 1; g<= num; g++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			ans = 0;
			start = 0;
			
			ll = new int[n];
			l = new int[n];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i< n; i++) {
				ll[i] = Integer.parseInt(st.nextToken());
			}
			l[0] = ll[0]; //초기값
			
			dp(1, k);
			
			bw.write("#" + g + " " + ans + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
