import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, max = Integer.MIN_VALUE;
	static int[][] graph, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int[][][] d = {{{-1, 0}, {1, 0}, {0, -1}}, {{-1, 0}, {1, 0}, {0, 1}}, {{-1, 0}, {0, -1}, {0, 1}}, {{1, 0}, {0, -1}, {0, 1}}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		isVisited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				isVisited[i][j] = true;
				dfs(new int[] {i, j}, 1, graph[i][j]);
				isVisited[i][j] = false;
				dfs2(new int[] {i, j});
			}
		}
		System.out.println(max);
	}
	static boolean[][] isVisited;
	static void dfs(int[] cur, int cnt, int sum) {
		if(cnt==4) {
			max = Math.max(max, sum);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int ni = cur[0] + dir[i][0];
			int nj = cur[1] + dir[i][1];
			
			if(ni<0 || nj<0 || ni>N-1 || nj>M-1 || isVisited[ni][nj]) {
				continue;
			}
			isVisited[ni][nj] = true;
			dfs(new int[] {ni, nj}, cnt + 1, sum + graph[ni][nj]);
			isVisited[ni][nj] = false;
		}
	}
	static void dfs2(int[] cur) {
		int sum = graph[cur[0]][cur[1]];
		for (int i = 0; i < 4; i++) {
			int temp = 0, cnt = 0;
			for (int j = 0; j < 3; j++) {
				int ni = cur[0] + d[i][j][0];
				int nj = cur[1] + d[i][j][1];
				
				if(ni<0 || nj<0 || ni>N-1 || nj>M-1) {
					break;
				}
				temp += graph[ni][nj];
				cnt++;
			}
			if(cnt==3) {
				max = Math.max(max, sum + temp);
			}
		}
	}
}
