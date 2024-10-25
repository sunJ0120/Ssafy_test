package D2;

import java.io.*;
import java.util.*;

public class SWEA_2005 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		for(int g = 1; g<=num; g++) {
			int n = Integer.parseInt(br.readLine());
			int[][] tryangle = new int[n][n];
			
			//초기화
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					tryangle[i][0] = 1;
					if(i == j) {
						tryangle[i][j] = 1;
					}else {
						continue;
					}
				}
			}
			
			//계산.
			int i = 2;
			int j = 1;
			
			while(i<n && j <n) {
				if(tryangle[i][j] != 1) {
					tryangle[i][j] = tryangle[i-1][j-1] + tryangle[i-1][j];
					j++;
				}else {
					i++;
					j = 1;
				}
				
			}
			
			bw.write("#" + g + "\n");
			
			//프린트
			for(int q = 0; q<n; q++) {
				for(int p = 0; p<n; p++) {
					if(tryangle[q][p] > 0) {
						bw.write("" + tryangle[q][p]+ " ");
					}else {
						bw.write("\n");
						break;
					}
				}
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
