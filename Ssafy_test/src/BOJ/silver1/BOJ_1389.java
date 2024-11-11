package BOJ.silver1;

import java.io.*;
import java.util.*;

class Graph_1389{
	
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
	
	Graph_1389(int size){
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
		n2.linked.add(n1);
	}
	
	int bacon;
	
	public void bfs(int start) {
		Queue<Node> que = new ArrayDeque<>();
		Queue<Integer> distance = new ArrayDeque<>();
		
		que.add(nodes[start]);
		distance.add(0);
		
		while(!que.isEmpty()) {
			Node n1 = que.poll();
			int d = distance.poll();
			
			if(!isVisited[n1.data]) {
				isVisited[n1.data] = true;
				bacon += d;
				
				for(Node n2 : n1.linked) {
					que.add(n2);
					distance.add(d+1);
				}
			}
		}
	}
	
	public void initVisit(int size) {
		for(int i = 1; i<= size; i++) {
			isVisited[i] = false;
		}
	}
}

public class BOJ_1389 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Graph_1389 gh = new Graph_1389(n);
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			gh.add(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int min = 0;
		int minIndex = 1;
		
		
		for(int i = 1; i<=n; i++) {
			gh.bacon = 0;
			gh.bfs(i);
			
			if(i == 1) { //초기 상태
				min = gh.bacon;
			}else {
				if(min > gh.bacon) {
					min = gh.bacon;
					minIndex = i;
				}
			}
			gh.initVisit(n);
		}
		
		bw.write(minIndex + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
