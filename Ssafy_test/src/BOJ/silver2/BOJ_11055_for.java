package BOJ.silver2;

import java.util.*;
import java.io.*;

public class BOJ_11055_for {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		int[] ll = new int[num];
		int[] sum = new int[num];
		int ans = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<num; i++) {
			ll[i] = Integer.parseInt(st.nextToken());
		}
		
		sum[0] = ll[0]; //초기값
		
		for(int i = 1; i<num; i++) {
			int max = 0;
			for(int j = i-1; j>=0; j--) {
				if(ll[i] > ll[j]) { //ll[j]가 더 작음
					max = Math.max(max, sum[j]);
				}
			}
			sum[i] = max + ll[i];
		}
		
		for(int i = 0; i<num; i++) {
			ans = Math.max(ans, sum[i]);
		}
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
