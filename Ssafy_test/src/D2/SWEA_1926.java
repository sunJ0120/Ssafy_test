package D2;

import java.io.*;
import java.util.*;

public class SWEA_1926 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 1; i<= n; i++) {
			int ans = 0;
			boolean flag = false;
			
			if(((i%100)%10 != 0) && ((i%100)%10 % 3 == 0)) {
				bw.write("-");
				flag = true;
			}
			
			if(((i%100)/10 != 0) && ((i%100)/10 % 3 == 0)) {
				bw.write("-");
				flag = true;
			}
			
			if((i/100 != 0) && (i/100 % 3 == 0)) {
				bw.write("-");
				flag = true;
			}
			
			if(!flag) {
				bw.write("" + i);
			}
			
			bw.write(" ");
			flag = false;
			
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
