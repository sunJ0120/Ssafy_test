package D2;

import java.io.*;
import java.util.*;

public class SWEA_1974 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		StringTokenizer st;

		for(int g = 1; g<= num; g++) {
			
			int[][] sdoku = new int[9][9];
			boolean[] nine;
			
			boolean row = false;
			boolean culumn = false;
			boolean rec = false;
			
			//저장 
			for(int i = 0; i<9; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<9; j++) {
					sdoku[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//가로
			for(int i = 0; i<9; i++) {
				nine = new boolean[10];
				for(int j = 0; j<9; j++) {
					if(!nine[sdoku[i][j]]) {
						nine[sdoku[i][j]] = true;
						row = true;
					}else {
						row = false;
						break;
					}
				}
			}
			
			//세로
			for(int i = 0; i<9; i++) {
				nine = new boolean[10];
				for(int j = 0; j<9; j++) {
					if(!nine[sdoku[j][i]]) {
						nine[sdoku[j][i]] = true;
						culumn = true;
					}else {
						culumn = false;
						break;
					}
				}
			}
			
			//3*3 이걸 쉽게 하는 법을 모르겠다....
			
		}
	}

}
