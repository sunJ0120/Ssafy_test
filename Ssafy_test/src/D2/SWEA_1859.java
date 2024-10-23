package D2;

import java.io.*;
import java.util.*;
/*
 * 백만장자 프로젝트
 * 결국, 수가 있을때, 최고점일때 판매하는 것이 목적이다.
 * 즉, 앞뒤로 비교했을때 이게 올라가는 수인지 아닌지를 따지는 것이 중요하다.
 * 1. 이중 for문을 둔다.
 * 2. i = 올라가고 떨어지는 부분을 구한다.
 * 3. j = i가 구해지면 각각의 차익을 계산해서 더한다.
 */
public class SWEA_1859 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		for(int g = 1; g<=num;g++) {
			int n = Integer.parseInt(br.readLine());
			List<Integer> money = new ArrayList<>();
			String[] str = br.readLine().split(" ");
			
			for(String st : str) {
				money.add(Integer.parseInt(st));
			}
			
			int max = Collections.max(money);
			
			int start = 0;
			int end = 0;
			int ans = 0;
			
			for(int i = 0; i< n; i++) {
				if(money.get(i) == max) {
					end = i;
				}else {
					continue;
				}
				
				for(int j = start; j<end ;j++) {
					ans += money.get(end) - money.get(j);
					money.set(j,0);
				}
				money.set(i,0);
				start = i+1;
				max = Collections.max(money);
			}
			
			bw.write("#" + g + " ");
			bw.write(ans + "\n");
		}
		bw.flush();
		br.close();
		bw.close();

	}

}
