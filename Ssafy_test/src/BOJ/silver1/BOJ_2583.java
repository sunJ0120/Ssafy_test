package BOJ.silver1;

import java.io.*;
import java.util.*;


public class BOJ_2583 {
	
	static int n;
	static int m;
	
	static int[] goX = {-1,0,1,0};
	static int[] goY = {0,1,0,-1};
	
	static boolean[][] isVisit;
	
	static int d;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int z = Integer.parseInt(st.nextToken());
		
		isVisit = new boolean[n][m];
		
		for(int i = 0; i<z; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = (n-1) - Integer.parseInt(st.nextToken());
			
			int x2 = Integer.parseInt(st.nextToken()); 
			int y2 = (n-1) - Integer.parseInt(st.nextToken());
			
			for(int p = y1; p>y2; p--) {
				for(int q = x1; q<x2;q++) {
					isVisit[p][q] = true;
				}
			}
		}
		
		List<Integer> l = new ArrayList<>();
		
		int count = 0;
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(!isVisit[i][j]) {
					isVisit[i][j] = true;
					d = 1;
					count++;
					
					dfs(j, i, d); //x,y
					l.add(d);
				}
			}
		}
		
		Collections.sort(l);
		bw.write(count + "\n");
		
		for(int i = 0; i<l.size(); i++) {
			bw.write(l.get(i) + " ");
		}
		bw.write("\n");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void dfs(int x, int y, int dept) {
		for(int i = 0; i<4; i++) {
			if(isIndexTrue(x, y, i) && !isVisit[y + goY[i]][x + goX[i]]){
				isVisit[y + goY[i]][x + goX[i]] = true;
				d++;
				dfs(x + goX[i], y + goY[i], dept+1);
			}
		}
	}
	
	public static boolean isIndexTrue(int x, int y, int z) {
		if(x + goX[z] >= 0 && x + goX[z] < m && y + goY[z] >= 0 && y + goY[z] < n) {
			return true;
		}
		return false;
	}
}
