import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] graph, dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] knight = { { -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 } };
	static boolean[][][] isVisited;
	static int K, W, H;// 횟수, 가로, 세로

	static class mk {
		int r, c, k, cnt;

		public mk(int r, int c, int k, int cnt) {
			this.r = r;
			this.c = c;
			this.k = k;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		graph = new int[H][W];
		isVisited = new boolean[K + 1][H][W];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(bfs());
	}

	static int bfs() {
		Queue<mk> q = new LinkedList<>();
		q.offer(new mk(0, 0, 0, 0));// r, c, k, cnt
		isVisited[0][0][0] = true;
		while (!q.isEmpty()) {
			mk m = q.poll();
			if (m.r == H - 1 && m.c == W - 1) {
				return m.cnt;
			}
			for (int i = 0; i < 4; i++) {
				int ni = m.r + dir[i][0];
				int nj = m.c + dir[i][1];

				if (ni < 0 || nj < 0 || ni > H - 1 || nj > W - 1 || isVisited[m.k][ni][nj] || graph[ni][nj] != 0) {
					continue;
				}
				isVisited[m.k][ni][nj] = true;
				q.offer(new mk(ni, nj, m.k, m.cnt + 1));
			}
			if (m.k < K) {
				for (int i = 0; i < 8; i++) {
					int ni = m.r + knight[i][0];
					int nj = m.c + knight[i][1];

					if (ni < 0 || nj < 0 || ni > H - 1 || nj > W - 1 || isVisited[m.k + 1][ni][nj] || graph[ni][nj] != 0) {
						continue;
					}
					isVisited[m.k + 1][ni][nj] = true;
					q.offer(new mk(ni, nj, m.k + 1, m.cnt + 1));
				}
			}
		}
		return -1;
	}
}
