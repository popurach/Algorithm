package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1388 {
	static int N, M, cnt = 0;
	static char[][] house;
	static boolean[][] isVisited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		house = new char[N][M];
		isVisited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				house[i][j] = str.charAt(j);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(isVisited[i][j]) {
					continue;
				}
				isVisited[i][j] = true;
				if(house[i][j] == '-') {
					dfs(i, j + 1, '-');
				} else {
					dfs(i + 1, j, '|');
				}
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	static void dfs(int y, int x, char prev) { 
		if(y >= N || x >= M || isVisited[y][x]) {
			return;
		}
		char cur = house[y][x];
		if(cur == prev) {// 이전 블록과 현재 블록이 같은 모양이라면
			isVisited[y][x] = true; // 현재 블록 방문 처리
			if(cur == '-') {
				dfs(y, x + 1, '-');
			} else {
				dfs(y + 1, x, '|');
			}
		}
	}
}
