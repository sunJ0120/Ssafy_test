package D3;

import java.io.*;
import java.util.*;

public class SWEA_1209 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[][] ll;
		List<Integer> l;
		
		for(int g = 1; g<= 10; g++) {
			int num = Integer.parseInt(br.readLine());
			ll = new int[100][100];
			l = new ArrayList<>(); //값 저장
			
			StringTokenizer st;
			
			for(int i = 0; i<100;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<100;j++) {
					ll[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//행의 합
			for(int i = 0; i<100;i++) {
				int ans = 0;
				for(int j = 0; j<100;j++) {
					ans += ll[i][j];
				}
				l.add(ans);
			}
			
			//열의 합
			for(int i = 0; i<100;i++) {
				int ans = 0;
				for(int j = 0; j<100;j++) {
					ans += ll[j][i];
				}
				l.add(ans);
			}
			
			//왼쪽 대각선의 합
			int ans = 0;
			for(int i = 0; i<100;i++) {
				ans += ll[i][i];
			}
			l.add(ans);
			
			//오른쪽 대각선의 합
			ans = 0;
			for(int i = 99; i<=0;i--) {
				ans += ll[i][i];
			}
			l.add(ans);
			
			bw.write("#" + g + " " + Collections.max(l) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
