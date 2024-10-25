package D2;

import java.io.*;
import java.util.*;

public class SWEA_1989 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		for(int g =1; g<= num; g++) {
			char[] pall = br.readLine().toCharArray();
			int start = 0;
			int end = pall.length -1;
			boolean flag = true;
			
			while(flag && start <= end) {
				if(pall[start] == pall[end]) {
					start++;
					end--;
				}else {
					flag = false;
				}
			}
			
			bw.write("#" + g + " ");
			
			if(flag) {
				bw.write(1 + "\n");
			}else {
				bw.write(0 + "\n");
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
