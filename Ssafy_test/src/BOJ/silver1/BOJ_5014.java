package BOJ.silver1;

import java.util.*;
import java.io.*;

public class BOJ_5014 {
	
	static long f;
	static long g;
	static long u;
	static long down;
	
	static int count;
	
	static boolean[] isVisit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		f = Long.parseLong(st.nextToken()); //최대층
		long s = Long.parseLong(st.nextToken()); //현재 내가 있는
		g = Long.parseLong(st.nextToken()); //갈 층
		u = Long.parseLong(st.nextToken()); //up
		down = Long.parseLong(st.nextToken()); //down
		
		count = 0;
		isVisit = new boolean[(int)f +1];
		bfs(s);
		
		if(s != g && count == 0) {
			bw.write("use the stairs" + "\n");
		}else {
			bw.write(count + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void bfs(long start) {
		Queue<Long> que = new ArrayDeque<>();
		Queue<Integer> distance = new ArrayDeque<>();
		
		que.add(start);
		distance.add(0);
		
		while(!que.isEmpty()) {
			long q = que.poll();
			int d = distance.poll();
			
			if(q == g) {
				count = d;
				break;
			}
			
			if(isTrue(q, u) && !isVisit[(int)(q+u)]) {
				isVisit[(int)(q+u)] = true;
				que.add(q + u);
				distance.add(d+1);
			}
			
			if(isTrue(q, -down)&& !isVisit[(int)(q-down)]) {
				isVisit[(int)(q-down)] = true;
				que.add(q - down);
				distance.add(d+1);
			}
		}
	}
	
	public static boolean isTrue(long a, long i) {
		if(a + i >= 1 && a + i <= f) {
			return true;
		}
		return false;
	}
}
