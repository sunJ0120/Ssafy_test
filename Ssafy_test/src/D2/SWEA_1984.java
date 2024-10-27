package D2;
import java.util.*;
import java.io.*;

public class SWEA_1984 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int g = 1; g<=num;g++) {
			List<Float> ll = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			float avg = 0;
		
			for(int i = 0; i<10; i++) {
				ll.add(Float.parseFloat(st.nextToken())); 
			}
			
			ll.remove(ll.indexOf(Collections.max(ll)));
			ll.remove(ll.indexOf(Collections.min(ll)));
			
			for(int i = 0; i<ll.size(); i++) {
				avg += ll.get(i);
			}
			bw.write("#" + g + " ");
			bw.write(Math.round(avg/8) + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
