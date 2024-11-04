package D3;

import java.io.*;
import java.util.*;

public class SWEA_1220 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int g = 1; g<= 1;g++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] magnet = new int[n][n];
			
			//수 정리
			for(int i = 0; i<n;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<n;j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//끝검사
			for(int i = 0; i<n; i++) {
				//위 검사 n = 1인지
				int j = 0;
				boolean t = true;
				
				//n 검사
				while(t) {
					if(magnet[j][i] == 2) {
						magnet[j][i] = 0;
					}else if(magnet[j][i] == 1) {
						t = false;
					}
					j++;
				}
				
				t = true;
				j = 100 - 1;
				
				//s검사
				while(t) {
					if(magnet[j][i] == 1) {
						magnet[j][i] = 0;
					}else if(magnet[j][i] == 2) {
						t = false;
					}
					j--;
				}
			}
			
			int count = 0;
			//검사
			for(int i = 0; i<n; i++) {
				boolean nFlag = false;
				boolean sFlag = false;
				
				for(int j = 0; j<n; j++) {
					if(nFlag&&sFlag) {
						count++;
						nFlag = false;
						sFlag = false;	
					}else {
						if(magnet[j][i] == 1) {
							nFlag = true;
						}else if(magnet[j][i] == 2) {
							sFlag = true;
						}
					}
				}
			}
			
			bw.write("#" + g + " " + count + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
