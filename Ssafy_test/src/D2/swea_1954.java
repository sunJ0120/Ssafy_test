package D2;

import java.util.ArrayList;
import java.util.Scanner;

public class swea_1954 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder stb = new StringBuilder();
		
		for(int k = 1; k<=n; k++) {
			int num = sc.nextInt();
			
			int count = 1;
			int i = 0;
			int j = 0;
			
			boolean right = true;
			boolean left = false;
			boolean up = false;
			boolean down = false;
			
			int[][] snail = new int[num][num];
			boolean[][] ox = new boolean[num][num];
			
			while(count <= num*num) {
				if(right) { //j++
					while(j < num && ox[i][j] == false ) {
						snail[i][j] = count;
						ox[i][j] = true;
						count++;
						j++;
					}
					j--;
					i++;
					
					right = false;
					down = true;
				}
				
				if(down) { //i++
					while(i < num && ox[i][j] == false) {
						snail[i][j] = count;
						ox[i][j] = true;
						count++;
						i++;
					}
					i--;
					j--;
					
					down = false;
					left = true;
				}
				
				if(left) { //j--
					while(j >= 0 && ox[i][j] == false) {
						snail[i][j] = count;
						ox[i][j] = true;
						count++;
						j--;
					}
					j++; //-1이 되어 버리므로
					i--;
					
					left = false;
					up = true;
				}
				
				if(up) { //i--
					while(i >= 0 && ox[i][j] == false) {
						snail[i][j] = count;
						ox[i][j] = true;
						count++;
						i--;
					}
					i++; //-1이 되어 버리므로
					j++;
					
					up = false;
					right = true;
				}
			}
			
			stb.append("#" + k);
			stb.append("\n"); //줄바꿈
			for(int z = 0; z<num; z++) {
				for(int t = 0; t<num; t++) {
					stb.append(snail[z][t] + " ");
				}
				stb.append("\n"); //줄바꿈
			}
		}
		System.out.println(stb);
	}
}
