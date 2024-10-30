package D3;

import java.io.*;
import java.util.*;

public class SWEA_1244 {
	
	static int maxValues;
	static char[] ll;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		
		for(int g = 1; g<=num;g++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			ll = st.nextToken().toCharArray();
		
			//depth 받기
			int count = Integer.parseInt(st.nextToken());
			
			maxValues = 0; //초기화는 여기서
			dfs(0,count);
			
			bw.write("#" + g + " ");
			bw.write(maxValues + "\n"); //dfs 계산
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
	//for문 교환
	//왼쪽이 오른쪽보다 커야 교환
	//visit를 비교해야 한다. - 백트래킹
	public static void dfs(int n, int count) {
		
		//종료조건, count 비교
		if(count == 0) {
			int currentValues = Integer.parseInt(new String(ll)); //배열을 바로 숫자로 바꾸는 방법 알아두깅
			maxValues = Math.max(currentValues, maxValues);
			return; //종료
		}
		
		//dfs
		for(int i = n; i< ll.length; i++) {
			for(int j = i+1; j< ll.length; j++) { 
				swap(i, j);
				dfs(i, count-1);
				swap(j, i); //복귀
			}
		}
	}
	
	public static void swap(int a, int b) { //교환. a,b는 index
		char t = ll[a];
		ll[a] = ll[b];
		ll[b] = t;
	}
}
