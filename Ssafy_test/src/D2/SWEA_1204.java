package D2;

import java.io.*;
import java.util.*;

public class SWEA_1204 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<num;i++) {
			List<Integer> li = new ArrayList<>();
			int[] lis = new int[101];
			
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j<1000; j++ ) {
				int a = Integer.parseInt(st.nextToken());
				lis[a]++; //하나 증가
			}
			for(int l:lis) {
				li.add(l); //직접 값을 복사
			}
			
			bw.write("#" + n + " ");
			
			for(int j = 100; j>=0; j-- ) {
				if(li.get(j) == Collections.max(li)) {
					bw.write(j + "\n"); //인덱스를 저장
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
