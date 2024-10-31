package D3;

import java.io.*;

public class SWEA_2806 {
	
	public static int[] queen;
	public static int ans;
	public static int N;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		for(int g = 1; g<=num;g++) {
			N = Integer.parseInt(br.readLine());
			queen = new int[N];
			ans = 0;
			
			dfs(0);
			
			bw.write("#" + g + " " + ans + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void dfs(int depth) {
		
		if(depth == N) { //최종 깊이
			ans++;
			return;
		}
		
		for(int i = 0; i<N;i++) { //queen[i] = depth로 하면 행의 값 i열 depth행 이런식
			queen[i] = depth;
			if(isPossible(depth)) {
				dfs(depth+1);
			}
		}
	}
	
	/*
	 * 목적은 가능한 수가 있는지 전체를 검사하는 것이다!
	 */
	public static boolean isPossible(int row) {
		for(int i = 0; i<row;i++) {
			if(queen[row] == queen[i] || Math.abs(queen[row] - queen[i]) == row - i) {
				return false;
			}
		}
		return true; //아무일 없이 빠져나오면 트루
	}
}
