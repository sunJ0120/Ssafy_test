package D3;

import java.util.*;
import java.io.*;

public class SWEA_1860 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		for(int g = 1; g<= num; g++) {
			bw.write("#" + g + " ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken()); //자격을 얻은 사람 갯수
			int m = Integer.parseInt(st.nextToken()); //m초마다
			int k = Integer.parseInt(st.nextToken()); //k개씩
			
			List<Integer> customer = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i< n; i++) {
				customer.add(Integer.parseInt(st.nextToken()));
			}
			
			Collections.sort(customer);
			
			int[] bread = new int[Collections.max(customer)+1]; //최대 길이
			
			for(int i = m; i<bread.length; i+=m) {
				for(int j = i; j< bread.length && j<i+m; j++) {
					bread[j] = k * (i/m);
				}
			}
			
			for(int i = 0; i< customer.size(); i++) {
				for(int j = customer.get(i); j< bread.length; j++) {
					bread[j]--;
				}
			}
			
			boolean flag = true;
			
			//음수 있나 검사
			for(int i = 0; i<bread.length; i++) {
				if(bread[i] < 0) {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				bw.write("Possible" + "\n");
			}else {
				bw.write("Impossible" + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
