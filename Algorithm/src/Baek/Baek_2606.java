package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_2606 {
	static int[][] arr;
	static int N, M, cnt = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
		M = Integer.parseInt(br.readLine()); // 컴퓨터의 번호 쌍
		
		arr = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());;
			
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		System.out.println(bfs());
	}
	static int bfs() {
		Queue<Integer> q = new LinkedList<>();
		boolean isVisited[] = new boolean[N + 1];
		q.add(1);
		isVisited[1] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 1; i < N + 1; i++) {
				if(isVisited[i] || arr[cur][i] == 0) {
					continue;
				}
				cnt++;
				q.add(i);
				isVisited[i] = true;
			}
		}
		return cnt;
	}
}
