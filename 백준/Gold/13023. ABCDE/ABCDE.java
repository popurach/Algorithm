import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M, flag = 0;
	static boolean[] isVisited;
	static ArrayList<ArrayList<Integer>> li;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		li = new ArrayList<>();
		isVisited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			li.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			li.get(a).add(b);
			li.get(b).add(a);
		}
		for (int i = 0; i < N; i++) {
			dfs(i, 1);
			if(flag == 1)
				break;
		}
		System.out.println(flag);
	}
	private static void dfs(int cur, int weight) {
		if(weight == 5) {
			flag = 1;
			return;
		}
		isVisited[cur] = true;
		for (int e : li.get(cur)) {
			if(isVisited[e])
				continue;
			dfs(e, weight+1);
		}
		isVisited[cur] = false;
	}
}
