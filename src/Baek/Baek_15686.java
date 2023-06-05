package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
// 조합 + 우선순위 큐
public class Baek_15686 {
	static int N, M, sum;
	static List<int[]> chicken;
	static List<int[]> house;
	static int[] numbers;
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	static void comb(int cnt, int start) {
		if(cnt == M) {
			sum = 0;
			for (int i = 0; i < house.size(); i++) {
				int min = 100;
				for (int j = 0; j < M; j++) {
					if(min > distance(chicken.get(numbers[j]), house.get(i))) {
						min = distance(chicken.get(numbers[j]), house.get(i));
					}
				}
				sum += min;
			}
			pq.offer(sum);
			return;
		}
		for (int i = start; i < chicken.size(); i++) {
			numbers[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}
	static int distance(int[] a, int[] b) {
		return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); //치킨집의 개수
		
		chicken = new ArrayList<int[]>();
		house = new ArrayList<int[]>();
		numbers = new int[M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 1) {
					house.add(new int[] {i, j});
				} else if(temp == 2) {
					chicken.add(new int[] {i, j});
				}
			}
		}
		comb(0, 0);
		System.out.println(pq.poll());
	}
}
