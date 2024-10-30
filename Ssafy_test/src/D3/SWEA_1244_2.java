package D3;

import java.io.*;
import java.util.*;

public class SWEA_1244_2 {
	
	static char[] ll;
	static int maxValue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		for(int g = 1; g<= num; g++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ll = st.nextToken().toCharArray();
			int count = Integer.parseInt(st.nextToken());
			
			maxValue = 0;
			dfs(0, count);
			
			bw.write("#" + g + " ");
			bw.write(maxValue + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static void dfs(int start, int count) {
		
		if(count == 0) {
			int currentValue =  Integer.parseInt(new String(ll));
			maxValue = Math.max(currentValue, maxValue);
			
			return;
		}
		
		for(int i = start; i<ll.length; i++) {
			for(int j = i+1; j<ll.length; j++) {
				swap(i,j);
				dfs(i,count-1);
				swap(j,i);
			}
		}
		
	}
	
	public static void swap(int a, int b) {
		char t = ll[a];
		ll[a] = ll[b];
		ll[b] = t;
	}
}
