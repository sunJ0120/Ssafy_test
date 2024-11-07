package D3;

import java.io.*;
import java.util.*;

public class SWEA_1493 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int max = 300;
		
		int num = Integer.parseInt(br.readLine());
		int[][] ll = new int[max][max];
		
		//초기값
		for(int i = max-1; i>=0; i--) {
			int jNum = ((max-1) - i) + 2;
			for(int j = 0; j<max; j++) {
				if(j == 0) {
					if(i == max-1) {
						ll[i][0] = 1; //초기값
					}else {
						ll[i][j] = ll[i+1][j] + ((max-1)-i);
					}
				}else {
					ll[i][j] = ll[i][j-1] + jNum++;
				}
			}
		}
		
		for(int g = 1; g<= num; g++) {
			bw.write("#" + g + " ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			int x =0;
			int y = 0;
			
			
			for(int n = 0; n<max; n++) {
				for(int m = 0; m<max; m++) {
					if(ll[n][m] == p) {
						x += m+1;
						y += (max)-n; 
						
					}
					
					if(ll[n][m] == q) {
						x += m+1;
						y += (max)-n;
					}
				}
			}
			
			bw.write(ll[(max-1)-(y-1)][x-1] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
