package D3;

import java.util.*;
import java.io.*;


public class SWEA_1228 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		for(int g = 1; g<=10; g++){
			bw.write("#" + g + " "); //앞 번호 저장
			
			int num = Integer.parseInt(br.readLine()); //원문 수
			List<String> sen = new ArrayList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			//원본 암호문 저장
			for(int i = 0; i<num; i++) {
				sen.add(st.nextToken()); //원문을 배열로 담기
			}
			
			int n = Integer.parseInt(br.readLine()); //암호문 갯수
			
			st = new StringTokenizer(br.readLine(), "I"); //1 5 400905 139831 966064 336948 119288, 이런식으로 잘림.
			List<String[]> listList = new ArrayList<>();
			
			for(int i = 0; i<n; i++) {
				StringTokenizer st2 = new StringTokenizer(st.nextToken()); //한번 더 자르기 //1,5,400905,139831... 
			
				String in = st2.nextToken(); //끼워 넣을 인덱스 //1
				int count = Integer.parseInt(st2.nextToken()); //5
				String[] stt = new String[count+1]; //암호문 저장을 위한 배열
				
				stt[0] = in;
				
				for(int j = 1; j<count+1; j++) {
					stt[j] = st2.nextToken(); //이렇게 하면 0번째 인덱스가 인덱스값, 나머지가 추가값
				}
				
				listList.add(stt);

			}
			
			//원본에 저장
			for(int i = 0; i<listList.size(); i++) {
				int ind = Integer.parseInt(listList.get(i)[0]); //0번째는 인덱스
				for(int j = 1; j<listList.get(i).length; j++) {
					sen.add(ind, listList.get(i)[j]);
					ind++; //하나씩 뒤로 보내면서 추가
				}
			}
			
			for(int i = 0; i<10; i++) {
				bw.write(sen.get(i) + " ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}
