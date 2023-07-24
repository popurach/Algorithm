package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_2206 {
	static int N, M;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static char[][] graph;
	
	static class move{
		int i, j, count;
		
		public move(int i, int j, int count) {
			super();
			this.count = count;
			this.i = i;
			this.j = j;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			graph[i] = str.toCharArray();
		}
		
		System.out.println(bfs());
	}
	static int bfs() {
		Queue<move> q = new LinkedList<>();
		boolean isVisited[][][] = new boolean[2][N][M];
		
		q.offer(new move(0, 0, 1));
		isVisited[1][0][0] = true;
		isVisited[0][0][0] = true;
		
		int cnt = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			cnt++;
			
			for (int i = 0; i < size; i++) {
				move cur = q.poll();
				if(cur.i == N-1 && cur.j == M-1) {
					return cnt;
				}
				
				for (int j = 0; j < dir.length; j++) {
					int ni = cur.i + dir[j][0];
					int nj = cur.j + dir[j][1];
					
					if(ni > N-1 || ni < 0 || nj > M-1 || nj < 0 || isVisited[cur.count][ni][nj]) {
						continue;
					}
					if(graph[ni][nj] == '0') {
						q.offer(new move(ni, nj, cur.count));
						isVisited[cur.count][ni][nj] = true;
						continue;
					}
					if(graph[ni][nj] == '1' && cur.count == 1) {
						q.offer(new move(ni, nj, 0));
						isVisited[0][ni][nj] = true;
					} 
					
				}
			}
		}
		return -1;
	}
}
