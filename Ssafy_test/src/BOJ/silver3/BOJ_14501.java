package BOJ.silver3;

import java.io.*;
import java.util.*;

public class BOJ_14501 {
	static int[] dayList;
	static int[] moneyList;
	static int[] dpList;
	static int num;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		num = Integer.parseInt(br.readLine());
		dayList = new int[num+1];
		moneyList = new int[num+1];
		dpList = new int[num+2];
		
		for(int i = 1; i<=num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			dayList[i] = a;
			moneyList[i] = b;
		}
		for(int i = 1; i<= num; i++) {
			if(dayList[i] + i <= num + 1) { //범위 안쪽으로 들어와야 한다.
				dpList[dayList[i]+i] = Math.max(moneyList[i] + dpList[i], dpList[dayList[i]+i]); //원래 있는 거랑, 갱신 값 중 최대 저장
			}
			//moneyList[i] + dpList[i] -> 여기서 dpList[i]는 여기까지 오는데 쓰인 이전 누적값 
			dpList[i+1] = Math.max(dpList[i], dpList[i+1]); //갱신값 쓰느냐, 이전 값을 그대로 쓰느냐
		//dpList[i+1] 이걸 해줘야 하는건, 다음에 움직일때 dpList[i]이 값을 써야 하니까!!
		}
		 
		int max = 0;
		for(int i = 1; i<= num+1; i++) {
			if(dpList[i] > max) {
				max = dpList[i];
			}
		}
		bw.write(max + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
