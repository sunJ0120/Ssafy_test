package BOJ.silver1;

import java.io.*;
import java.util.*;

public class BOJ_7562 {
	
	static int n;
	static int x2;
	static int y2;
	
	static int[] goX = {-2,-1,2,1,-2,-1,2,1};
	static int[] goY = {-1,-2,-1,-2,1,2,1,2};
	
	static boolean[][] isVisit;
	
	static int dis;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine()); //testCase
		
		for(int i = 0; i<num;i++) {
			n = Integer.parseInt(br.readLine()); //n*n
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			isVisit = new boolean[n][n];
			
			dis = 0;
			bfs(x1,y1);
			
			bw.write(dis + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void bfs(int x, int y) {
		Queue<Integer> Xque = new ArrayDeque<>(); //x
		Queue<Integer> Yque = new ArrayDeque<>(); //y
		Queue<Integer> distance = new ArrayDeque<>(); //d
		
		Xque.add(x);
		Yque.add(y);
		distance.add(0);
		
		isVisit[y][x] = true;
		
		while(!Xque.isEmpty()) {
			int x1 = Xque.poll();
			int y1 = Yque.poll();
			int d = distance.poll();
			
			if(x1 == x2 && y1 == y2) { //도착
				dis = d;
				break;
			}
			
			for(int i = 0; i<8;i++) {
				if(isIndexTrue(x1, y1, i) && !isVisit[y1 + goY[i]][x1 + goX[i]]) {
					isVisit[y1 + goY[i]][x1 + goX[i]] = true;
					
					Xque.add(x1 + goX[i]);
					Yque.add(y1 + goY[i]);
					distance.add(d+1);
				}
			}
		}
	}
	
	public static boolean isIndexTrue(int x, int y, int z) {
		if(x + goX[z] >= 0 && x + goX[z] < n && y + goY[z] >= 0 && y + goY[z] < n) {
			return true;
		}
		return false;
	}

}
