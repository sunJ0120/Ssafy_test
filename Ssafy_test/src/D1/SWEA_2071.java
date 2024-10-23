package D1;

import java.io.*;
import java.util.*;

public class SWEA_2071 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st ;
		for(int i = 1; i<=3; i++) {
			st = new StringTokenizer(br.readLine());
			float sum = 0;
			int ans;
			
			for(int j = 0; j<10; j++) {
				sum += Integer.parseInt(st.nextToken());
			}
			
			ans = Math.round(sum/10);
			bw.write("#" + i + " " + ans + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}	
}
