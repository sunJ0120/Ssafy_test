package BOJ.silver2;

import java.io.*;
import java.util.*;

public class BOJ_11053 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		int[] ll = new int[num];
		int[] length = new int[num];
		int ans = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<num; i++) {
			ll[i] = Integer.parseInt(st.nextToken());
		}
		
		length[0] = 1;
		
		for(int i = 1; i<num; i++) {
			int max = 0;
			for(int j = i-1; j>= 0; j--) {
				if(ll[j] < ll[i]) {
					max = Math.max(max, length[j]);
				}
			}
			length[i] = max + 1;
		}
		
		for(int i = 0; i<num; i++) {
			ans = Math.max(ans, length[i]);
		}
	
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
