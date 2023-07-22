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
	static int N;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static char[][] graph;
	static List<int[]> teacher;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		teacher = new ArrayList<>();
		
		graph = new char[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = st.nextToken().charAt(0);
				if(graph[i][j] == 'T') {
					teacher.add(new int[] {i, j});
				}
			}
		}
		comb(0, 0);
		System.out.println("NO");
	}
	static void comb(int start, int cnt) {
		if(cnt == 3) {
			if(bfs()) {
				System.out.println("YES");
				System.exit(0);
			}
			return;
		}
		for (int c = start; c < N*N; c++) {
			int i = c / N;
			int j = c % N;
			
			if(graph[i][j] == 'X') {
				graph[i][j] = 'O';
				comb(c + 1, cnt + 1);
				graph[i][j] = 'X';
			}
		}
	}
	static boolean bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][][] isVisited = new boolean[N][N][4];
		
		teacher.forEach(t -> {
			for (int i = 0; i < 4; i++) {
				q.offer(new int[] {t[0], t[1], i});
				isVisited[t[0]][t[1]][i] = true;
			}
		});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			int ni = cur[0] + dir[cur[2]][0];
			int nj = cur[1] + dir[cur[2]][1];
			
			if(ni < 0 || nj < 0 || ni >= N || nj >= N || isVisited[ni][nj][cur[2]]) {
				continue;
			}
			if(graph[ni][nj] == 'S') {
				return false;
			} else if(graph[ni][nj] == 'X') {
				q.offer(new int[] {ni, nj, cur[2]});
				isVisited[ni][nj][cur[2]] = true;
			}
		}
		return true;
	}
}