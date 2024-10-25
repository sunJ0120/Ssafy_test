package D2;

import java.io.*;
import java.util.*;

public class SWEA_1961 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		for(int g = 1; g<=num;g++) {
			int n = Integer.parseInt(br.readLine());
			int[][] ll = new int[n][n];
			
			int[][] l1 = new int[n][n]; //90
			int[][] l2 = new int[n][n]; //180
			int[][] l3 = new int[n][n]; //270
			
			StringTokenizer st;
			
			for(int i = 0; i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<n; j++) {
					ll[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//90
			for(int i = 0; i<n;i++) {
				for(int j = 0; j<n; j++) {
					l1[j][i] = ll[n-i-1][j];
				}
			}
			
			//180
			for(int i = 0; i<n;i++) {
				for(int j = 0; j<n; j++) {
					l2[j][i] = l1[n-i-1][j];
				}
			}
			
			//270
			for(int i = 0; i<n;i++) {
				for(int j = 0; j<n; j++) {
					l3[j][i] = l2[n-i-1][j];
				}
			}
			
			//출력
			bw.write("#" + g + "\n");
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					bw.write(""+l1[i][j]);
				}
				bw.write(" ");
				for(int j = 0; j<n; j++) {
					bw.write(""+l2[i][j]);
				}
				bw.write(" ");
				for(int j = 0; j<n; j++) {
					bw.write(""+l3[i][j]);
				}
				bw.write("\n");
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}

}
