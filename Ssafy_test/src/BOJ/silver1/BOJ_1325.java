package BOJ.silver1;

import java.io.*;
import java.util.*;

class Graph{
	
	class Node{
		int data;
		Set<Node> linked;
		Node(int data){
			this.data = data;
			linked = new HashSet<>();
		}
	}
	
	Node[] nodes;
	boolean[] isVisited;
	
	Graph(int size){
		nodes = new Node[size + 1];
		isVisited = new boolean[size + 1];
		
		for(int i = 1; i<= size; i++) {
			nodes[i] = new Node(i);
		}
	}
	
	public void add(int a, int b) {
		Node n1 = nodes[a];
		Node n2 = nodes[b];
		
		n1.linked.add(n2);
	}
	
	int count;
	
	public void bfs(int start) {
		Queue<Node> que = new ArrayDeque<>();
		Node n = nodes[start];
		que.add(n);
		count = 1;
		
		while(!que.isEmpty()) {
			Node n1 = que.poll();
			if(!isVisited[n1.data]) {
				isVisited[n1.data] = true;
				for(Node n2 : n1.linked) {
					count++;
					que.add(n2);
				}
			}
		}
		
	}
	
	public void initList(int size) {
		for(int i = 1; i<= size; i++) {
			if(isVisited[i]) {
				isVisited[i] = false;
			}
		}
	}
	
}

public class BOJ_1325 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Graph gh = new Graph(n);
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			gh.add(b, a);
		}
		
		int max = 1;
		List<Integer> ll = new ArrayList<>();
		
		for(int i = 1; i<=n; i++) {
			if(!gh.isVisited[i]) {
				gh.bfs(i);
				
				if(gh.count > max) {
					max = gh.count;
					ll.clear(); //한번 비우기
					ll.add(i);
				}else if(gh.count == max) {
					ll.add(i);
				}
				gh.initList(n); //초기화
			}
		}
		
		Collections.sort(ll); //오름차순 정렬
		
		for(int i = 0; i < ll.size(); i++) {
			bw.write(ll.get(i) + " ");
		}
		bw.write("\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
