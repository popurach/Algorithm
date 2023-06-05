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

// 게리맨더링
public class Baek_17471 {
	static int N, min = Integer.MAX_VALUE; // 구역의 개수
	static int[] people;
	static boolean[] check, isVisited;
	static List<Integer>[] graph;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		people = new int[N + 1];
		graph = new ArrayList[N + 1];
		check = new boolean[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				graph[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		for (int i = 1; i < N; i++) {
			comb(i, 1, 0);
		}
		if(min == Integer.MAX_VALUE) {
			min = -1;
		}
		System.out.println(min);
	}
	
	static void comb(int num, int start, int cnt) {
		if(cnt == num) {
			isVisited = new boolean[N + 1];
			bfs();
			return;
		}
		
		for (int i = start; i <= N; i++) {
			check[i] = true;
			comb(num, i + 1, cnt + 1);
			check[i] = false;
		}
	}
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		
		// 선거구 1에 포함되어 있는 지역 한 개 추가
		for (int i = 1; i <= N; i++) {
			if(check[i]) {
				q.offer(i);
				isVisited[i] = true;
				break;
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for (int i = 0; i < graph[cur].size(); i++) {
				int temp = graph[cur].get(i);
				
				if(!isVisited[temp] && check[temp]) {
					q.offer(temp);
					isVisited[temp] = true;
				}
			}
		}
		
		// 선거구 2에 포함되어 있는 지역 한 개 추가
		for (int i = 1; i <= N; i++) {
			if(!check[i]) {
				q.offer(i);
				isVisited[i] = true;
				break;
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for (int i = 0; i < graph[cur].size(); i++) {
				int temp = graph[cur].get(i);
				if(!isVisited[temp] && !check[temp]) {
					q.offer(temp);
					isVisited[temp] = true;
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if(!isVisited[i]) {
				return;
			}
		}
		
		int a=0, b=0;
		for (int i = 1; i <= N; i++) {
			if(check[i]) {
				a += people[i];
			} else {
				b += people[i];
			}
		}
		if(Math.abs(a - b) < min) {
			min = Math.abs(a - b);
		}
	}
}
