package D2;

import java.util.Scanner;

/*
 * 파스칼의 삼각형
 * 
 * - 아이디어를 못 얻어서 애먹었다ㅠㅠ이런건 무조건 행렬로 생각하기
 * 
 * 행렬로 둔다.
 * 재귀를 사용하는데, DP로 저장하면서 사용한다.
 * 
 * 행과 열이 같거나, 열이 0인 경우는 전부 1이다.
 * 열이 행보다 큰 경우는 RETURN 한다.
 * 그렇지 않으면, 대각선 윗 값 + 윗값을 진행하고 배열에 넣는다.
 * 
 * 전체적으로 배열에 값이 있으면 그 값을 사용하고, 없으면 재귀한다.
 * 
 */


public class swea_2005 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		StringBuilder stb = new StringBuilder();
		
		for(int z = 1; z <= num; z++) { //반복수
			int n = sc.nextInt();
			
			int[][] dp = new int[n][n];
			
			for(int i = 0; i<n; i++) { //행
				for(int j = 0; j<n; j++) { //렬
					if(i == j || j == 0) {
						dp[i][j] = 1;
					}else if(i < j) {
						dp[i][j] = 0;
					}else {
						if(i > 0 && j > 0) {
							dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
						}
					}
				}
			}
			
			stb.append("#" + z + "\n");
			
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					if(dp[i][j] == 0) {
						continue;
					}else {
						stb.append(dp[i][j] + " ");
					}
				}
				stb.append("\n");
			}
		}
		System.out.println(stb);
	}

}
