package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
// 미생물 : 여러 군집이 합쳐질 때 방향은 숫자가 많은 군집의 방향으로 정해진다
// 3개의 군집이 합쳐질 때 우선순위 큐를 사용하지 않으면 숫자가 가장 큰 군집의 방향이라고 규정할 수 없음
// => 우선순위 큐 사용
public class SW_2382 {
	static int N, M, K;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //상 하 좌 우
	static List<microbe> microbes;
	static microbe[][] graph;
	static StringBuilder sb;
	static class microbe implements Comparable<microbe>{
		int y, x, num, d;

		public microbe(int y, int x, int num, int d) {
			super();
			this.y = y;
			this.x = x;
			this.num = num;
			this.d = d;
		}

		@Override
		public int compareTo(microbe o) {
			return o.num - this.num;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //가로, 세로
			M = Integer.parseInt(st.nextToken()); // 시간
			K = Integer.parseInt(st.nextToken()); // 미생물 군집 개수
			
			graph = new microbe[N][N];
			microbes = new LinkedList<microbe>();
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				
				microbes.add(new microbe(y, x, num, d));
			}
			
			sb.append("#" + tc + " " + bfs() + "\n");
		}
		System.out.println(sb);
	}
	static int bfs() {
		PriorityQueue<microbe> q = new PriorityQueue<>();
		
		for (int i = 0; i < microbes.size(); i++) {
			q.offer(microbes.get(i));
		}
		
		while(!q.isEmpty() && M!=0) {
			M--;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				microbe temp = q.poll();
				temp.y += dir[temp.d - 1][0];
				temp.x += dir[temp.d - 1][1];
				
				if(temp.y == 0 || temp.x == 0 || temp.y == N-1 || temp.x == N-1) {
					if(temp.d == 1 || temp.d ==3) {
						temp.d += 1;
					} else {
						temp.d -= 1;
					}
					temp.num /= 2;
				}
				if(temp.num == 0) {
					continue;
				}
				if(graph[temp.y][temp.x] == null) {
					graph[temp.y][temp.x] = temp;
				} else {
					graph[temp.y][temp.x].num += temp.num;
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(graph[i][j] != null) {
						q.offer(graph[i][j]);
						graph[i][j] = null;
					}
				}
			}
		}
		int sum = 0;
		while(!q.isEmpty()) {
			sum += q.poll().num;
		}
		return sum;
	}
}
