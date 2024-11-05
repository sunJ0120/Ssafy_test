package D3;

import java.io.*;
import java.util.*;

public class SWEA_1225 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int g = 0; g<10;g++) {
			int num = Integer.parseInt(br.readLine());
			bw.write("#" + num + " ");
			
			LinkedList<Integer> ll = new LinkedList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i< 8; i++) {
				ll.add(i, Integer.parseInt(st.nextToken()));
			}
			
			int j = 1;
			
			while(!ll.contains(0)) {
				int n = ll.get(0);
				
				if(n - j < 0) {
					n = 0;
				}else {
					n -= j;
				}
				
				ll.remove(0);
				ll.add(n);
				j++;
				
				if(j > 5) {
					j = 1; //초기화
				}
			}
			
			for(int i = 0; i<ll.size();i++) {
				bw.write(ll.get(i) + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
