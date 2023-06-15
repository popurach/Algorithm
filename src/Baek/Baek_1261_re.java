package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * 미로에서 도착 지점까지 가는 최소 벽을 부수는 경우의 수
 * Priority Queue 이용 -> 벽을 깬 횟수를 정렬 기준
 * */
public class Baek_1261_re {
    static class location implements Comparable<location>{
        int y, x, wall;

        public location(int y, int x, int wall) {
            this.y = y;
            this.x = x;
            this.wall = wall;
        }

        @Override
        public int compareTo(location o) {
            return this.wall - o.wall;
        }
    }
    static int M, N;
    static int[][] graph, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String temp = br.readLine();
            for (int j = 1; j <= M; j++) {
                graph[i][j] = temp.charAt(j - 1) - '0';
            }
        }
        bfs();
    }
    static void bfs() {
        PriorityQueue<location> pq = new PriorityQueue<>();
        boolean[][] isVisited = new boolean[N + 1][M + 1];
        pq.offer(new location(1, 1, 0));
        isVisited[1][1] = true;

        while (!pq.isEmpty()) {
            location cur = pq.poll();
            if(cur.y == N && cur.x == M) {
                System.out.println(cur.wall);
                return;
            }
            for (int i = 0; i < dir.length; i++) {
                int ni = cur.y + dir[i][0];
                int nj = cur.x + dir[i][1];

                if(ni < 1 || nj < 1 || ni > N || nj > M || isVisited[ni][nj]) {
                    continue;
                }
                if(graph[ni][nj] == 0) {
                    pq.offer(new location(ni, nj, cur.wall));
                } else if(graph[ni][nj] == 1) {
                    pq.offer(new location(ni, nj, cur.wall + 1));
                }
                isVisited[ni][nj] = true;
            }
        }
    }
}
