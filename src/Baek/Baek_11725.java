package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_11725 {
	static int N;
	static boolean[] isVisited;
	static List<Integer>[] graph;
	static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N + 1];
		isVisited = new boolean[N + 1];
		parent = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		bfs();
		for (int i = 2; i <= N; i++) {
			sb.append(parent[i] + "\n");
		}
		System.out.println(sb);
	}
	static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		isVisited[1] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				int cur = q.poll();
				
				for (int i = 0; i < graph[cur].size(); i++) {
					int next = graph[cur].get(i);
					if(!isVisited[next]) {
						q.offer(next);
						isVisited[next] = true;
						parent[next] = cur;
					}
				}
			}
		}
	}
}
