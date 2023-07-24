import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, max;
	// 0: 빈칸 1: 벽 2: 바이러스
	static int[][] graph, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static List<int[]> virus;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		virus = new ArrayList<int[]>();
		max = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if(graph[i][j]==2) {
					virus.add(new int[] {i, j});
				}
			}
		}
		comb(0, 0);
		System.out.println(max);
	}

	static void comb(int cnt, int start) {
		if (cnt == 3) {
			bfs();
			return;
		}
		for (int i = start; i < N * M; i++) {
			int y = i / M;
			int x = i % M;
			if (graph[y][x] == 0) {
				graph[y][x] = 1;
				comb(cnt + 1, i + 1);
				graph[y][x] = 0;
			}
		}
	}
	static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		for (int i = 0; i < virus.size(); i++) {
			q.offer(virus.get(i));
		}
		int[][] copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			copy[i] = Arrays.copyOf(graph[i], graph[i].length);
		}
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int ni = cur[0] + dir[i][0];
				int nj = cur[1] + dir[i][1];
				
				if(ni<0 || nj<0 || ni>N-1 || nj>M-1 || copy[ni][nj]!=0) {
					continue;
				}
				copy[ni][nj] = 2;
				q.offer(new int[] {ni, nj});
			}
		}
		check(copy);
	}
	static void check(int[][] copy) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(copy[i][j]==0) {
					cnt++;
				}
			}
		}
		max = Math.max(max, cnt);
	}
}
