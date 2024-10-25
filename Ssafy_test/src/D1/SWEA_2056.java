package D1;

import java.io.*;

/*
 * 풀이 전략
 * * 유효성 검사를 단계별로 나눠서 진행한다.
 * 1. 년도에 대한 유효성 검사 : 0000 ~ 9999
 * 2. 월에 대한 유효성 검사 : 01 ~ 12
 * 3. 일에 대한 유효성 검사 : 1,3,5,7,8,10,12 = 31
 * 4,6,8,10 = 31
 * 2 = 28
 * 
 * 4,2,2 단위로 잘라서 숫자로 바꿔서 사용한다.
 */

public class SWEA_2056 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		for(int i = 1; i<=num;i++) {
			String str = br.readLine();
			int n = Integer.parseInt(str);
			int year = n /10000;
			int month = (n % 10000) / 100;
			int day = (n % 10000) % 100; 
			
			boolean t = false;
			
			if(year > 0) {
				if(1<=month && month<=12) {
					if(month == 2) {
						if(1 <= day&&28 >= day) {
							t = true;
						}
					}else if(month == 4||month == 6||month == 8||month == 10) {
						if(1 <= day&&30 >= day) {
							t = true;
						}
					}else {
						if(1 <= day&&31 >= day) {
							t = true;
						}
					}
				}
			}
			if(t) {
				bw.write("#" + i + " ");
				bw.write(str.substring(0,4) + "/");
				bw.write(str.substring(4,6) + "/");
				bw.write(str.substring(6,8) + "\n");
			}else {
				bw.write("#" + i + " ");
				bw.write(-1 + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
