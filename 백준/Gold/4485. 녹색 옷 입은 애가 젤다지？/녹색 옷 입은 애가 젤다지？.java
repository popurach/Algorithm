import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, cnt = 0;
	static int[][] dist, adjMatrix, dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean[][] isVisited;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		while (true) {
			
			N = Integer.parseInt(br.readLine());
			if(N==0)
				break;
			cnt++;
			adjMatrix = new int[N][N];
			isVisited = new boolean[N][N];
			dist = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					adjMatrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			bfs();
		}
		System.out.print(sb);
	}

	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { 0, 0 });
		isVisited[0][0] = true;
		for (int i = 0; i < N; i++) {// 무한 초기화
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		dist[0][0] = adjMatrix[0][0];

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			//System.out.println(Arrays.toString(cur));

			for (int i = 0; i < dir.length; i++) {
				int ni = cur[0] + dir[i][0];
				int nj = cur[1] + dir[i][1];

				if (ni < 0 || nj < 0 || ni > N - 1 || nj > N - 1) {
					continue;
				}
				int temp = adjMatrix[ni][nj] + dist[cur[0]][cur[1]];
				if (dist[ni][nj] > temp) {
					dist[ni][nj] = temp;
					q.offer(new int[] { ni, nj });
				}
				
//				for (int j = 0; j < dist.length; j++) {
//					System.out.println(Arrays.toString(dist[i]));
//				}
			}
		}
		sb.append("Problem " + cnt + ": " + dist[N - 1][N - 1] + "\n");
	}
}
