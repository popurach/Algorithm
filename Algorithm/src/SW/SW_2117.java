package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 맨허튼 거리 사용 (bfs x)
public class SW_2117 {
	static int N, M, max, maxSize;
	static List<int[]> house;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			max = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			house = new ArrayList<int[]>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					if(Integer.parseInt(st.nextToken()) == 1) {
						house.add(new int[] {i, j});
					}
				}
			}
			maxSize = N;
			int sum = house.size() * M; // 집으로부터 얻을 수 있는 최대 이익
			for (int i = 1; i <= N; i++) {
				if(sum < cost(i)) {
					maxSize = i - 1; // 지을 수 있는 영역의 최대 크기 
					break;
				}
			}
			for (int s = 0; s <= maxSize; s++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						int temp = 0;
						for (int h = 0; h < house.size(); h++) {
							if(distance(house.get(h), i, j)<=s) {
								temp++;
							}
						}
						if(temp * M - cost(s + 1) >= 0) {
							max = Math.max(max, temp);
						}
					}
				}
			}
			sb.append("#" + tc + " " + max + "\n");
		}
		System.out.println(sb);
	}
	static int cost(int k) {
		return k*k + (k-1)*(k-1);
	}
	static int distance(int[] arr, int i, int j) {
		return Math.abs(arr[0] - i) + Math.abs(arr[1] - j);
	}
}
