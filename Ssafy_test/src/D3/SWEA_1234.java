package D3;

import java.io.*;
import java.util.*;

public class SWEA_1234 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int g = 1; g<= 10; g++) {
			bw.write("#" + g + " ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			
			char[] c = st.nextToken().toCharArray();
			List<Integer> ll = new ArrayList<>();
			
			for(char cc : c) {
				ll.add(cc - '0'); //수로 저장
			}
			
			int start = 0;
			int end = start+1;
			
			while(end < ll.size()) {
				if(ll.get(start) == ll.get(end)) {
					ll.remove(start);
					ll.remove(start); //자리가 바뀌기 때문에 end를 지우는게 아니라 start를 두번 지움
					
					if(start != 0) { //start가 0일 경우는 start를 움직이면 안된다.
						end = start;
						start--;
					}
				}else { //같지 않을 경우, 둘다 플러스
					start++;
					end++;
				}
			}
			
			for(int i = 0; i<ll.size();i++) {
				bw.write(""+ll.get(i));
			}
			bw.write("\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
