package D3;

import java.io.*;
import java.util.*;

public class SWEA_1208 {
	public static List<Integer> ll;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int g = 1; g<= 10; g++) {
			int leg = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			ll = new ArrayList<Integer>();
			
			for(int i = 0; i<100;i++) {
				ll.add(Integer.parseInt(st.nextToken()));
			}
			
			bw.write("#" + g + " ");
			bw.write(deep(leg) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int deep(int count) {
	    while (count > 0) {
	        int max = Collections.max(ll);
	        int min = Collections.min(ll);

	        // 최대값이 있는 인덱스를 찾아서 -1, 최소값이 있는 인덱스를 찾아서 +1
	        for (int i = 0; i < ll.size(); i++) {
	            if (ll.get(i) == max) {
	                ll.set(i, ll.get(i) - 1);
	                break;
	            }
	        }
	        
	        for (int i = 0; i < ll.size(); i++) {
	            if (ll.get(i) == min) {
	                ll.set(i, ll.get(i) + 1);
	                break;
	            }
	        }
	        
	        count--;
	    }
	    // 최종적으로 최대값과 최소값을 계산하여 그 차이를 반환
	    return Collections.max(ll) - Collections.min(ll);
	}
}
