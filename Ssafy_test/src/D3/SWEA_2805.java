package D3;

import java.io.*;
import java.util.*;

public class SWEA_2805 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		for(int g = 1; g<= num; g++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] farm = new int[n][n];
			
			int ans = 0;
			
			//저장
			for(int i = 0; i<n;i++) {
				char[] ch = br.readLine().toCharArray();
				for(int j = 0; j<n;j++) {
					farm[i][j] = ch[j]-'0';
				}
			}
			
			int start = n/2 + 1;
			int end = n/2 - 1;
			
			for(int i = 0; i<n; i++) {
				if(i <= n/2) {
					start--;
					end++;
				}else {
					start++;
					end--;
				}
				
				for(int j = start; j<=end; j++) {
					ans += farm[i][j];
				}
			}
			bw.write("#" + g + " " + ans + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
