package D2;

import java.io.*;
import java.util.*;

public class SWEA_1979 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st; 
		
		for(int g = 1; g <= num; g++) {
			
			st = new StringTokenizer(br.readLine()); //n k

			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int[][] li = new int[n][n];
			int ans = 0;
			
			//저장
			for(int i = 0; i< n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j< n; j++) {
					li[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int check = 0;
			
			//가로
			for(int i = 0; i< n; i++) {
				for(int j = 0; j< n; j++) {
					if(li[i][j] == 1) {
						check++;
					}else {
						if(check == k) {
							ans++;
						}
						check = 0; //초기화
					}
				}
				
				if(check == k) {
					ans++;
				}
				check = 0; //초기화
			}
			
			//세로
			for(int i = 0; i< n; i++) {
				for(int j = 0; j< n; j++) {
					if(li[j][i] == 1) {
						check++;
					}else {
						if(check == k) {
							ans++;
						}
						check = 0; //초기화
					}
				}
				
				if(check == k) {
					ans++;
				}
				check = 0; //초기화
			}
			bw.write("#" + g + " ");
			bw.write(ans + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
