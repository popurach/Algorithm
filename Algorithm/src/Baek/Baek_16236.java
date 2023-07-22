package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 처음 아기 상어의 크기 : 2
 * 1초에 상하좌우 이동
 * 자신의 크기보다 큰 물고기 이동 불가, 나머지 이동 가능
 * 자신의 크기보다 작은 물고기 먹을 수 있음
 * */
public class Baek_16236 {
	static class fish implements Comparable<fish>{
		int i, j, size, move, num; // 크기, 먹은 물고기의 수

		public fish(int i, int j, int size, int move, int num) {
			super();
			this.i = i;
			this.j = j;
			this.size = size;
			this.move = move;
			this.num = num;
		}

		@Override
		public int compareTo(fish o) {
			if(this.i == o.i) {
				return this.j - o.j; 
			}
			return this.i - o.i;
		}
	}
	static PriorityQueue<fish> pq;
	static fish shark;
	static int N, time = 0;
	static int[][] graph, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if(graph[i][j] == 9) { // 아기 상어
					graph[i][j] = 0;
					shark = new fish(i, j, 2, 0, 0); // i, ㅓ, size
				} 
			}
		}
		bfs();
		System.out.println(time);
	}
	static void bfs() {
		Queue<fish> q = new LinkedList<>();
		boolean[][] isVisited = new boolean[N][N];
		q.offer(shark);
		isVisited[shark.i][shark.j] = true;
		int count = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			count++; // 아기 상어의 위치에서 이동한 횟수
			for (int s = 0; s < size; s++) {
				fish cur = q.poll();
				for (int i = 0; i < dir.length; i++) {
					int ni = cur.i + dir[i][0];
					int nj = cur.j + dir[i][1];
					
					if(ni < 0 || nj < 0 || ni > N - 1 || nj > N - 1 || isVisited[ni][nj] || graph[ni][nj] > shark.size) {
						continue;
					}
					q.offer(new fish(ni, nj, 0, 0, 0));
					isVisited[ni][nj] = true;
					
					if(graph[ni][nj] > 0 && graph[ni][nj] < shark.size) {
						pq.offer(new fish(ni, nj, graph[ni][nj], count, 0));
					}
				}
			}
			
			// 잡아먹을 물고기가 있다면
			if(pq.size() > 0) {
				fish ate = pq.poll();
				time += ate.move;
				
				shark.i = ate.i;
				shark.j = ate.j;
				shark.num++;
				if(shark.num >= shark.size) {
					shark.size++;
					shark.num = 0;
				}
				graph[ate.i][ate.j] = 0;
				
				pq.clear();
				
				for (int i = 0; i < N; i++) {
					Arrays.fill(isVisited[i], false);
				}
				
				q.clear();
				q.add(shark);
				isVisited[shark.i][shark.j] = true;
				count = 0;
			}
		}
	}
}
