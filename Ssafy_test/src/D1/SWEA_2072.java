package D1;

import java.io.*;
import java.util.*;

public class SWEA_2072 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i = 1; i<=n;i++) {
			int ans = 0;
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<10;j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num %2 != 0) {
					ans += num;
				}
			}
			bw.write("#" + i  + " " + ans + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}

}
