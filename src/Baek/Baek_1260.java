package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_1260 {
	static int N, M, V;
	static List<Integer>[] graph;
	static boolean[] isVisited;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		sb = new StringBuilder();
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		for (int i = 1; i < N + 1; i++) {
			Collections.sort(graph[i]);
		}
		isVisited = new boolean[N + 1];
		isVisited[V] = true;
		dfs(V);
		sb.append("\n");
		Arrays.fill(isVisited, false);
		bfs();
		System.out.println(sb);
	}
	static void dfs(int start) {
		sb.append(start + " ");
		for (int i = 0; i < graph[start].size(); i++) {
			int temp = graph[start].get(i);
			if(isVisited[temp]) {
				continue;
			}
			isVisited[temp] = true;
			dfs(temp);
//			isVisited[temp] = false;
		}
	}
	static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		isVisited[V] = true;
		q.add(V);
		sb.append(V + " ");
		while(!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 0; i < graph[cur].size(); i++) {
				int temp = graph[cur].get(i);
				if(isVisited[temp]) {
					continue;
				}
				isVisited[temp] = true;
				q.add(temp);
				sb.append(temp + " ");
			}
		}
	}
}
