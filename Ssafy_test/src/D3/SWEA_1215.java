package D3;

import java.io.*;
import java.util.*;

public class SWEA_1215 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int g = 1; g<=10;g++) {
			int ans = 0;
			
			int num = Integer.parseInt(br.readLine());
			char[][] pal = new char[8][8];
			
			//저장
			for(int i = 0; i<8; i++) {
				pal[i] = br.readLine().toCharArray();
			}
			
			//행 검사
			for(int i = 0; i<8;i++) { //줄
				for(int j = 0; j<=8-num;j++) { //시작점
					boolean T = false;
					int start = j;
					int end = j+(num-1);
					
					while(start<end) { //내부 검사
						if(pal[i][start] == pal[i][end]) {
							T = true;
							
							start++;
							end--;
						}else {
							T = false;
							break;
						}
					}
					
					if(T) {
						ans++;
					}
				}
			}
			
			//열 검사
			for(int i = 0; i<8;i++) { //줄
				for(int j = 0; j<=8-num;j++) { //시작점
					boolean T = false;
					int start = j;
					int end = j+(num-1);
					
					while(start<end) { //내부 검사
						if(pal[start][i] == pal[end][i]) {
							T = true;
							
							start++;
							end--;
						}else {
							T = false;
							break;
						}
					}
					
					if(T) {
						ans++;
					}
				}
			}
			
			bw.write("#" + g + " " + ans + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
