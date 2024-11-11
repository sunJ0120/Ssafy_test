package BOJ.silver1;

import java.io.*;
import java.util.*;

public class BOJ_1697 {
	
	static int m;
	static boolean[] isVisit;
	static int ans;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		isVisit = new boolean[Math.max(n, m) + 2]; //아하....뒤로 갈 수 있기 때문에 배열은 동생 기준으로 잡을 수 없다!
		ans = 0;
		bfs(n);
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void bfs(int start) {
		Queue<Integer> que = new ArrayDeque<>();
		Queue<Integer> distance = new ArrayDeque<>();
		
		que.add(start);
		distance.add(0);
		
		while(!que.isEmpty()) {
			int q = que.poll();
			int d = distance.poll();
			
			if(q == m) {
				ans = d;
				break;
			}
			
			if(!isVisit[q]) {
				isVisit[q] = true;
				
				if(q*2 > 0 && q*2 <= m+1) {
					que.add(q*2);
					distance.add(d+1);
				}
				
				if(q+1 > 0 && q+1 <= m+1) {
					que.add(q+1);
					distance.add(d+1);
				}
				
				if(q-1 >= 0) {
					que.add(q-1);
					distance.add(d+1);
				}
			}
		}
	}
}
