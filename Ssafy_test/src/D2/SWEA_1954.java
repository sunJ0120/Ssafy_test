package D2;

import java.io.*;
import java.util.*;

public class SWEA_1954 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		for(int g = 1; g<= num; g++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] snake = new int[n][n];
			boolean[][] snakeT = new boolean[n][n];
			
			int nn = 1;
			
			int i = 0;
			int j = 0;
			
			bw.write("#"+ g + "\n");
			
			while(nn <= n*n) { //아직 채울 수가 남음
				//오른쪽으로 
				while(j<n && snakeT[i][j] == false) { //&& 조건 순서 주의
					snake[i][j] = nn++;
					snakeT[i][j++] = true;
				}
				
				j--;
				i++;
				
				//아래로
				while(i<n && snakeT[i][j] == false) {
					snake[i][j] = nn++;
					snakeT[i++][j] = true;
				}
				
				i--;
				j--;
				
				//왼쪽으로 
				while(j>=0 && snakeT[i][j] == false) {
					snake[i][j] = nn++;
					snakeT[i][j--] = true;
				}
				
				j++;
				i--;
				
				//위로
				while(i>=0 && snakeT[i][j] == false) {
					snake[i][j] = nn++;
					snakeT[i--][j] = true;
				}
				
				i++;
				j++;
			}
			
			for(int q = 0; q <n; q++) {
				for(int p = 0; p <n; p++) {
					bw.write(snake[q][p] + " ");
				}
				bw.write("\n");
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
