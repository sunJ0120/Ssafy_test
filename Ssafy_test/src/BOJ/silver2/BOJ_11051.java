package BOJ.silver2;

import java.util.*;
import java.io.*;

public class BOJ_11051 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] c = new int[n+1][m+1]; 
		
		if(n >= 2 && m >= 1) {
			c[2][1] = 2; //여기까지 초기화 해야 한다.
		}
	
		for(int i = 1; i<=n; i++) {
			for(int j = 0; j<= (i > m ? m : i) ; j++) {
				if(j == 0) {
					c[i][j] = 1;
				}
				
				if(i == j) {
					c[i][j] = 1;
				}
			}
		}
		
		//이항 계수
		for(int i = 2; i<=n; i++) {
			for(int j = 1; j<= (i > m ? m : i); j++) {
				if(c[i][j] == 0) { //아직 안채워짐
					c[i][j] = (c[i-1][j-1] + c[i-1][j]) % 10007;
				}
			}
		}
		bw.write(c[n][m] + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
