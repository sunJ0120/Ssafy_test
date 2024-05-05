package D2;
/*
 * 369게임
 * 관건은, 3, 6, 9가 들어간 숫자의 경우 -를 출력하는 것이다.
 */

import java.util.Scanner;

public class swea_1926 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		StringBuilder stb = new StringBuilder();
		int count = 1;
		
		while(count <= num) { 
			char[] ch = Integer.toString(count).toCharArray();
			boolean flag = false;
			for(int i = 0; i<ch.length; i++) {
				if(ch[i] == '3'||ch[i] == '6'||ch[i] == '9') {
					stb.append("-");
					flag = true;
				}
			}
			if(!flag) {
				stb.append(count);
			}
			stb.append(" ");
			count++;
		}
		
		System.out.println(stb);

	}

}
