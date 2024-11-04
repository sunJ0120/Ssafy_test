package D3;

import java.io.*;
import java.util.*;

class Graph{
	class Node{
		int data;
		boolean visit;
		List<Node> link;
		
		Node(int data){
			this.data = data;
			visit = false;
			link = new ArrayList<>();
		}
	}
	
	Node[] nodes;
	
	Graph(int size){
		nodes = new Node[size+1];
		
		for(int i = 1; i<= size; i++) {
			nodes[i] = new Node(i);
		}
	}
	
	public void add(int a, int b) {
		Node n1 = nodes[a];
		Node n2 = nodes[b];
		
		if(!n1.link.contains(n2)) {
			n1.link.add(n2);
		}
		
		if(!n2.link.contains(n1)) {
			n2.link.add(n1);
		}
	}
	
	int maxNode = 1;
	
	public void dfs(int start, int node) {
		Node n = nodes[start];
		n.visit = true;
		
		for(Node n1 : n.link) {
			
			if(maxNode < node) {
				maxNode = node;
			}
			
			if(!n1.visit) {
				dfs(n1.data, node+1);
			}
		}
		
		n.visit = false;
	}
	
}

public class SWEA_2814 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		for(int g = 1; g<= num; g++) {
			bw.write("#" + g + " ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken()); //node 수
			int m = Integer.parseInt(st.nextToken()); //간선 수 
			
			Graph gh = new Graph(n);
			
			for(int i = 0; i<m;i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken()); 
				int b = Integer.parseInt(st.nextToken());
				
				gh.add(a, b);
			}
			
			int ans = 1;
			
			for(int i = 1; i<=n;i++) {
				gh.dfs(i,1);
				if(gh.maxNode > ans) {
					ans = gh.maxNode;
				}
				
				for(int j = 1; j<=n; j++) { //초기화
					gh.nodes[j].visit = false;
				}
			}
			
			bw.write( ans + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
