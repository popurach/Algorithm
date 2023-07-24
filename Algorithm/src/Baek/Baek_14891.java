package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_14891 {
	static int K;
	static boolean[] isVisited;
	static char[][] arr;
	static Queue<int[]> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		arr = new char[4][8];
		q = new LinkedList<int[]>();
		
		for (int i = 0; i < 4; i++) {
			String str = br.readLine();
			arr[i] = str.toCharArray();
		}
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			isVisited = new boolean[4];
			
			q.offer(new int[] {a - 1, b});
			isVisited[a - 1] = true;
			bfs();
		}
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			if(arr[i][0] == '1') {
				sum += Math.pow(2, i);
			}
		}
		System.out.println(sum);
		// 2 6 비교
		
	}
	static void bfs() {
		int[] rotate = new int[4];
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			rotate[cur[0]] = cur[1];
			
			if(cur[0] - 1 >=0 && !isVisited[cur[0] - 1]) { // 좌측
				if(arr[cur[0]][6] != arr[cur[0] - 1][2]) {
					q.offer(new int[] {cur[0] - 1, cur[1] * (-1)});
					isVisited[cur[0] - 1] = true;
				}
			}
			if(cur[0] + 1 < 4 && !isVisited[cur[0] + 1]) { // 우측
				if(arr[cur[0]][2] != arr[cur[0] + 1][6]) {
					q.offer(new int[] {cur[0] + 1, cur[1] * (-1)});
					isVisited[cur[0] + 1] = true;
				}
			}
		}
		
		for (int i = 0; i < 4; i++) {
			if(rotate[i] == 1) { // 시계 방향
				char temp = arr[i][7];
				for (int j = 6; j >=0; j--) {
					arr[i][j + 1] = arr[i][j];
				}
				arr[i][0] = temp;
			} else if(rotate[i] == -1) { // 반시계 방향
				char temp = arr[i][0];
				for (int j = 1; j < 8; j++) {
					arr[i][j - 1] = arr[i][j];
				}
				arr[i][7] = temp;
			}
		}
	}
}
