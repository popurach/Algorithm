import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static int[][] graph, copy, dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		graph = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int time = 0, prev_Cnt = 0;
		while (true) {
			int temp = bfs();
			if(temp == 0) {
				break;
			}
			time++;
			prev_Cnt = temp;
		}
		System.out.println(time);
		System.out.println(prev_Cnt);
	}

	static int bfs() {// 치즈를 만나면 0으로 만들고 큐에 삽입은 X
		int cnt = 0;
		boolean[][] isVisited = new boolean[R][C];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0 });
		isVisited[0][0] = true;
		copy = new int[R][C];
		for (int i = 0; i < R; i++) {
			copy[i] = Arrays.copyOf(graph[i], graph[i].length);
		}
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int ni = cur[0] + dir[i][0];
				int nj = cur[1] + dir[i][1];

				if (ni < 0 || nj < 0 || ni > R - 1 || nj > C - 1 || isVisited[ni][nj]) {
					continue;
				}
				isVisited[ni][nj] = true;
				if (graph[ni][nj] == 0) {
					q.add(new int[] { ni, nj });
				} else if (graph[ni][nj] == 1) {
					copy[ni][nj] = 0;// 외곽에 있는 치즈 녹이기
					cnt++;
				}
			}
		}
		graph = copy;
		return cnt;
	}
}
