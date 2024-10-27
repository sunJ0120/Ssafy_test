package D3;

import java.util.*;
import java.io.*;

public class SWEA_1206 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		for(int g = 1;g<=10; g++) {
			int ans = 0;
			int num = Integer.parseInt(br.readLine());
			
			List<Integer> l = new ArrayList<>();
			int[] ll = new int[num];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i<num;i++) {
				l.add(Integer.parseInt(st.nextToken()));
			}
			
			int start = 2;
			int end = 5;
			
			while(end <= num) {
				int max = 0;
				
				for(int i = start-2; i<end;i++) {
					if(i != start && l.get(i) > max) {
						max = l.get(i);
					}
				}
				
				ll[start] = l.get(start) - max;
				
				start++;
				end++;
			}
			
			//더하기
			for(int i = 2; i<num-2;i++) {
				if(ll[i] > 0) {
					ans += ll[i];
				}
			}
			bw.write("# " + g + " ");
			bw.write(ans + "\n");
		}
		bw.flush();
		br.close();
		bw.close();

	}

}
