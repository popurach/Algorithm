import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_1707_BFS {
	static int K, V, E;
	static int[] color;
	static List<Integer>[] graph;
	static boolean flag;
	static boolean[] isVisited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		for (int k = 0; k < K; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[V + 1];
			for (int i = 1; i <= V; i++) {
				graph[i] = new ArrayList<Integer>();
			}
			color = new int[V + 1];
			isVisited = new boolean[V + 1];
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a].add(b);
				graph[b].add(a);
			}
			flag = true;
			for (int i = 1; i <= V; i++) {
				if(!isVisited[i]) {
					bfs(i, 1);
				}
				if(!flag) {
					break;
				}
			}
			if(flag) {
				sb.append("YES\n");
			}else {
				sb.append("NO\n");
			}
		}
		System.out.println(sb);
	}
	static void bfs(int start, int col) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		isVisited[start] = true;
		color[start] = col;
		while(!q.isEmpty() && flag) {
			int cur = q.poll();
			for (int i = 0; i < graph[cur].size(); i++) {
				int current = graph[cur].get(i);
				if(color[current]==0) {
					color[current] = color[cur] * (-1);
					q.offer(current);
					isVisited[current] = true;
				}else {
					if(color[cur]==color[current]) {
						flag = false;
						return;
					}
				}
			}
		}
	}
}
