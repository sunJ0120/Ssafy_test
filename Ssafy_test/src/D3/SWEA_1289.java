package D3;

import java.io.*;

public class SWEA_1289 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		for(int g = 1;g<= num; g++) {
			String memory = br.readLine();
			char[] ch = memory.toCharArray();
			char[] reset = new char[ch.length];
			
			//초기화
			for(int p = 0; p<ch.length; p++) {
				reset[p] = '0';
			}
			
			int i = 0;
			int count = 0;
			
			while(!new String(reset).equals(memory) || i < ch.length) {
				if(reset[i] != ch[i]) {
					count++;
					char c = reset[i];
					for(int j = i; j<ch.length;j++) {
						if(c == '0') {
							reset[j] = '1';
						}else {
							reset[j] = '0';
						}
					}
				}
				i++;
			}
			bw.write("#"+ g + " " + count + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
