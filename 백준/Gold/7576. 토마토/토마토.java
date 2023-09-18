import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class fruit {
		int n, m, depth;

		public fruit(int n, int m, int depth) {
			this.n = n;
			this.m = m;
			this.depth = depth;
		}
	}

	static int M, N, cur_depth;// 가로, 세로
	static int[][] graph, dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean[][] visited;
	static Queue<fruit> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		graph = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if (graph[i][j] == 1)
					q.add(new fruit(i, j, 0));
			}
		}

		bfs();
		if (check()) {
			System.out.println(cur_depth);
		} else {
			System.out.println(-1);
		}
	}

	private static boolean check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] == 0)
					return false;
			}
		}
		return true;
	}

	static void bfs() {
		while (!q.isEmpty()) {
			fruit cur = q.poll();
			for (int i = 0; i < dir.length; i++) {
				int ni = cur.n + dir[i][0];
				int nj = cur.m + dir[i][1];

				if (ni < 0 || nj < 0 || ni > N - 1 || nj > M - 1 || visited[ni][nj] || graph[ni][nj] == -1) {
					continue;
				}
				if (graph[ni][nj] == 0) {
					q.offer(new fruit(ni, nj, cur.depth + 1));
					cur_depth = Math.max(cur_depth, cur.depth + 1);
					visited[ni][nj] = true;
					graph[ni][nj] = 1;
				}
			}
		}
	}
}
