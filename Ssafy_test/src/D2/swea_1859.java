package D2;
/*
 복습 필수
 */

import java.util.Scanner;

public class swea_1859 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int i = 1; i <= num; i++) {
			int n = sc.nextInt();
			
			int[] list = new int[n];
			int[] maxlist = new int[n];
			long ans = 0;
			int max;
			int start = 0;
		
			
			for(int j = n-1; j>=0; j--) {
				list[j] = sc.nextInt(); //거꾸로 저장
			}
			
			max = list[0]; 
			
			for(int k = 0; k<n; k++) {
				if(max < list[k]) {
					max = list[k];
				}
				maxlist[k] = max;
			}
			
			for(int z = 0; z<n; z++) {
				ans += (maxlist[z] - list[z]);
			}
			System.out.println("#" + i + " " + ans);
		}

	}

}
