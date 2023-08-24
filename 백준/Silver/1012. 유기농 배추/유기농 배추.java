import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] graph, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static boolean[][] isVisited;
	static int M, N, K, total_Cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			total_Cnt = 0;
			graph = new int[M][N];
			isVisited = new boolean[M][N];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				graph[x][y] = 1;
			}
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(!isVisited[i][j] && graph[i][j]==1) {
						total_Cnt++;
						bfs(new int[] {i, j});
					}
				}
			}
			sb.append(total_Cnt + "\n");
		}
		System.out.print(sb);
	}
	static void bfs(int[] idx) {
		Queue<int[]> que = new LinkedList<>();
		que.add(idx);
		isVisited[idx[0]][idx[1]] = true;
		while(!que.isEmpty()) {
			int[] temp = que.remove();
			for (int i = 0; i < dir.length; i++) {
				int ni = temp[0] + dir[i][0];
				int nj = temp[1] + dir[i][1];
				
				if(ni<0 || nj<0 || ni>M-1 || nj>N-1 || isVisited[ni][nj]) {
					continue;
				}
				if(graph[ni][nj]==0) {
					continue;
				}
				que.add(new int[] {ni, nj});
				isVisited[ni][nj] = true;
			}
		}
	}
}
