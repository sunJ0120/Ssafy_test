package D3;

import java.io.*;
import java.util.*;

public class SWEA_1216 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int g = 0; g<10; g++) {
			int num = Integer.parseInt(br.readLine());
			bw.write("#" + num + " ");
			
			char[][] ch = new char[100][100];
			
			//저장
			for(int i = 0; i<100;i++) {
				ch[i] = br.readLine().toCharArray();
			}
			
			boolean t = true;
			int maxNum = 1;
			
			//가로			
			for(int i = 0; i<100; i++) {
				for(int j = 2; j<100;j++) { //길이 기준. 
					for(int z = 0; z < 100-j; z++) { //시작점
						int start = z;
						int end = z+j;
						while(start < end) {
							if(ch[i][start] != ch[i][end]) {
								t = false;
								break;
							}else {
								t = true;
								start++; 
								end--;
							}
						}
						if(t) { //true 라면, 해당 길이의 팰린드롬을 찾은 것으로 더이상 찾을 필요가 없다.
							break;
						}
					}
					if(t) { //팰린드롬
						maxNum = Math.max(j+1, maxNum);
					}
				}
			}
			
			//세로			
			for(int i = 0; i<100; i++) {
				for(int j = 2; j<100;j++) { //길이 기준. 
					for(int z = 0; z < 100-j; z++) { //시작점
						int start = z;
						int end = z+j;
						while(start < end) {
							if(ch[start][i] != ch[end][i]) {
								t = false;
								break;
							}else {
								t = true;
								start++; 
								end--;
							}
						}
						if(t) { //true 라면, 해당 길이의 팰린드롬을 찾은 것으로 더이상 찾을 필요가 없다.
							break;
						}
					}
					if(t) { //팰린드롬
						maxNum = Math.max(j+1, maxNum);
					}
				}
			}
			bw.write(maxNum + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
