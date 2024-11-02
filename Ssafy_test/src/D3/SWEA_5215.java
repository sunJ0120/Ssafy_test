package D3;

import java.io.*;
import java.util.*;

public class SWEA_5215 {
	
	static int kcalMax;
	static int food;
	
	static int[] score;
	static int[] kcals;
	
	static int kcal;
	
	static int maxScore;
	static int currentScore;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		for(int g = 1; g<= num;g++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			food = Integer.parseInt(st.nextToken());
			kcalMax = Integer.parseInt(st.nextToken());
			
			score = new int[food];
			kcals = new int[food];
			
			for(int i = 0; i<food; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				kcals[i] = Integer.parseInt(st.nextToken());
			}
			
			kcal = 0;
			
			maxScore = 0;
			currentScore = 0;
			
			dfs(0);
			
			bw.write("#" + g + " " + maxScore + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dfs(int i) {
		
		if(i >= food || kcal > kcalMax) {
			return;
		}
		
		for(int j = i; j<food; j++) {
			kcal += kcals[j];
			currentScore += score[j];
			
			if(kcal <=  kcalMax && maxScore < currentScore) { //여기서 kcal <=  kcalMax 이 조건을 한 번더 체크해야 한다!!!
				maxScore = currentScore;
			}
			
			dfs(j+1);
			
			kcal -= kcals[j]; //원복
			currentScore -= score[j];
			
		}
	}
}
