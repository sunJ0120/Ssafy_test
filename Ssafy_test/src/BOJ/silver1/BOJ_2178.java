package BOJ.silver1;

import java.io.*;
import java.util.*;

public class BOJ_2178 {
	
	static int n;
	static int m;
	
	static int[][] maze;
	
	static int[] goX = {-1,0,1,0};
	static int[] goY = {0,1,0,-1};
	
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		maze = new int[n][m];
		
		//미로 저장
		for(int i = 0; i<n;i++) {
			char[] c = br.readLine().toCharArray();
			for(int j = 0; j<m;j++) {
				maze[i][j] = c[j] - '0';
			}
		}
		
		ans = 0;
		bfs(0, 0); //1,1 부터 시작
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void bfs(int x, int y) {
		Queue<Integer> Xque = new ArrayDeque<>(); //x이동 방향 저장
		Queue<Integer> Yque = new ArrayDeque<>(); //y이동 방향 저장
		Queue<Integer> distance = new ArrayDeque<>(); //높이 저장
		
		boolean[][] isVisit = new boolean[n][m];
		
		Xque.add(x);
		Yque.add(y);
		distance.add(1);
		
		isVisit[y][x] = true;
		
		//셋 중 하나라도 empty이면 안 된다.
		while(!Xque.isEmpty() && !Yque.isEmpty() && !distance.isEmpty()) {
			int x1 = Xque.poll();
			int y1 = Yque.poll();
			int d1 = distance.poll();
			
			if(y1 == n-1 && x1 == m-1) { //도달하고자 하는 높이에 도달
				ans = d1;
				break;
			}
			
			for(int i = 0; i<4; i++) { //4방향을 체크해야 한다.
				if(isTrueIndex(x1, y1, i) && !isVisit[y1+goY[i]][x1+goX[i]] && maze[y1+goY[i]][x1+goX[i]] == 1) {
					Xque.add(x1+goX[i]);
					Yque.add(y1+goY[i]);
					distance.add(d1+1);
					
					isVisit[y1+goY[i]][x1+goX[i]] = true;
					//visit를 해야 하는건, 뒤로 가지 않게끔 하기 위함이다.
				}
			}
		}
	}
	
	public static boolean isTrueIndex(int x, int y, int z) {
		if(x + goX[z] >= 0 && x + goX[z] < m && y + goY[z] >= 0 && y + goY[z] < n) {
			return true;
		}
		return false;
	}
}
