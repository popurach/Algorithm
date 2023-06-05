import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_1707_DFS {
	static int k, v, e;
	static int[] vertex;
	static List<Integer>[] graph;
	static boolean flag;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		k = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			
			vertex = new int[v + 1];
			graph = new ArrayList[v + 1];
			
			for (int j = 1; j <= v; j++) {
				graph[j] = new ArrayList<Integer>();
			}
			for (int j = 0; j < e; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a].add(b);
				graph[b].add(a);
			}
			
			flag = true;
			for (int j = 1; j <= v; j++) {
				if(vertex[j]!=0) {
					continue;
				}
				dfs(j, 1);
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
	static void dfs(int start, int color) {
		vertex[start] = color;
		
		for (int i = 0; i < graph[start].size(); i++) {
			if(vertex[graph[start].get(i)]==0) {
				dfs(graph[start].get(i), color*(-1));
			}else {
				if(vertex[graph[start].get(i)]==color) {
					flag = false;
					return;
				}
			}
			if(!flag) {
				return;
			}
		}
		
	}
}
