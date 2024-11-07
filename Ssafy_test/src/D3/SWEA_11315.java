package D3;

import java.io.*;
import java.util.*;

public class SWEA_11315 {
	
	static int n;
	
	static int[][] ll;
	
	static int[] goX = {-1,-1,1,1,0,-1,0,1}; //대각선, 상좌하우
	static int[] goY = {-1,1,1,-1,-1,0,1,0};
	
	static boolean t;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		for(int g = 1; g<= num; g++) {
			bw.write("#" + g + " ");
			
			n = Integer.parseInt(br.readLine());
			ll = new int[n][n];
			
			t = false;
			
			//저장
			for(int i = 0; i<n; i++) {
				char[] c = br.readLine().toCharArray();
				for(int j = 0; j<n; j++) {
					if(c[j] == 'o') {
						ll[i][j] = 1;
					}
				}
			}
			
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					if(ll[i][j] == 1) {
						for(int z = 0; z<8; z++) { //한 방향으로 나아감
							dfs(j,i,z,4);
							
							if(t) {
								break;
							}
						}
					}
					if(t) {
						break;
					}
				}
				if(t) {
					break;
				}
			}
			
			if(t){
				bw.write("YES" + "\n");
			}else {
				bw.write("NO" + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dfs(int x, int y, int z, int count) {
		if(count == 0) {
			t = true; //오목 돌 존재
			return;
		}
		if(isIndexTrue(x, y, z) && ll[y + goY[z]][x + goX[z]] == 1) { //범위 안에 들어옴
			dfs(x + goX[z], y + goY[z], z, count-1);
		}else {
			return; //끝내기. 이 방향은 탐색할 필요 없음
		}
	}
	
	public static boolean isIndexTrue(int x, int y, int z) {
		if(x + goX[z] >= 0 && y + goY[z] >= 0 && x + goX[z] < n && y + goY[z] < n) {
			return true;
		}
		return false;
	}

}
