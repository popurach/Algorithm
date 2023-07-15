import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, cnt = 0;
	static int[][] graph;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs2(1, 0, 1);
		System.out.println(cnt);
	}
	
	static void dfs2(int type, int nx, int ny) {
		if(nx == N && ny == N)
			cnt++;
		if(type==1) {
			if(check(new int[] {nx, ny}) && graph[nx][ny]==0) {
				dfs2(1, nx, ny+1);
				dfs2(3, nx + 1, ny + 1);
			}
		} else if(type ==2) {
			if(check(new int[] {nx, ny}) && graph[nx][ny]==0) {
				dfs2(2, nx + 1, ny);
				dfs2(3, nx + 1, ny + 1);
			}
		} else if(type == 3) {
			if(check(new int[] {nx, ny}) && graph[nx][ny]==0 && graph[nx-1][ny]==0 && graph[nx][ny-1]==0) {
				dfs2(1, nx, ny+1);
				dfs2(2, nx + 1, ny);
				dfs2(3, nx + 1, ny + 1);
			}
		}
	}
	static boolean check(int[] cur) {
		if(cur[0]>=0 && cur[0]<N && cur[1]>=0 && cur[1]<N && graph[cur[0]][cur[1]]==0)
			return true;
		return false;
	}
}
