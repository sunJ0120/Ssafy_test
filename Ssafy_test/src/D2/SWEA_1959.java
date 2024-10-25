package D2;

import java.io.*;
import java.util.*;

public class SWEA_1959 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int g = 1; g<=num;g++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
					
			int[] al = new int[a];
			int[] bl = new int[b];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<a; i++) {
				al[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<b; i++) {
				bl[i] = Integer.parseInt(st.nextToken());
			}
			
			int start = 0;
			int end = (a > b ? b : a);
			int max = 0;
			int nn = 0;
		
			while(end <= (a > b ? a : b)) {
				int sum = 0;
				for(int i = start; i<end;i++) {
					sum += (a > b ? al[i]*bl[nn] : bl[i]*al[nn]);
					nn++;
				}
				if(max < sum) {
					max = sum;
				}
				start++;
				end++;
				nn = 0;
			}
			bw.write("#" + g + " " + max + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
