package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_17070 {
	static int N, cnt = 0;
	static int[][] arr, dir = {{0, 1}, {1, 0}, {1, 1}}; // 우, 하, 우하
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(new int[] {0, 1}, 0);
		System.out.println(cnt);
	}
	static void dfs(int[] start, int d) {
		if(start[0] == N-1 && start[1] == N-1) { // 종결 조건
			cnt ++;
			return;
		}
		int ni = start[0], nj = start[1];
		// 가로
		if(d != 1 && nj + 1 < N && arr[ni][nj + 1] != 1) {
			dfs(new int[] {ni, nj + 1}, 0);
		}
		// 세로
		if(d != 0 && ni + 1 < N && arr[ni + 1][nj] != 1) {
			dfs(new int[] {ni + 1, nj}, 1);
		}
		// 대각선
		if(ni + 1 < N && nj + 1 < N) {
			if(arr[ni][nj + 1] != 1 && arr[ni + 1][nj] != 1 && arr[ni + 1][nj + 1] != 1) {
				dfs(new int[] {ni + 1, nj + 1}, 2);
			}
		}
	}
}
