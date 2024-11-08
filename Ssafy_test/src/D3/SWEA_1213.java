package D3;

import java.io.*;

public class SWEA_1213 {
	
	static char[] c;
	static char[] ch;
	
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int g = 0; g<10; g++) {
			int n = Integer.parseInt(br.readLine());
			bw.write("#" + n + " ");
			
			c = br.readLine().toCharArray(); //작은거
			ch = br.readLine().toCharArray(); //원본
			
			int start = 0;
			int end = c.length;
			count = 0;
			
			recursion(start, end);
			
			bw.write(count + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void recursion(int start, int end) {
		
		boolean flag = false;
		
		if(end > ch.length) {
			return; //끝내기
		}
		
		for(int i = start; i<end;i++) {
			if(c[i-start] == ch[i]) { //i-start 해줘야 첫 번째에서 계산 가능
				flag = true;
			}else {
				flag = false;
				break;
			}
		}
		
		if(flag) { //true, 즉 모두 같을 경우
			count++;
		}
		
		recursion(start+1, end+1);
	}
}
