package D2;

/*
 * 삼중 for문 어떻게 잡아야 하는지 전혀 감이 안옴...예시 참고...
 */

import java.io.*;
import java.util.*;

public class SWEA_2001 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int g = 1; g<=num;g++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[][] fly = new int[n][n];
			
			//저장
			for(int i = 0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<n; j++) {
					fly[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		
		}
	}

}
