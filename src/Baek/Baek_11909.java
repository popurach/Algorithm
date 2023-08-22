package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * 배열 탈출
 * graph[0][0] 에서 출발해서 graph[n-1][n-1] 이동
 * 1≤i,j<n이라면, 상수는 A[i][j+1] 또는 A[i+1][j]로만 건너갑니다
 * i=n 또는 j=n이면 각각 우, 하로 이동
 * 다익스트라 알고리즘
 * */
public class Baek_11909 {
    static class human{
        int i, j, total;

        public human(int i, int j, int total) {
            this.i = i;
            this.j = j;
            this.total = total;
        }
    }
    static int n;
    static int[][] graph, D, dir  = {{1, 0}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        D = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(D[i], 10000000);
        }
        bfs();
        System.out.println(D[n-1][n-1]);
    }
    static void bfs() {
        PriorityQueue<human> pq = new PriorityQueue<>((x, y) -> x.total - y.total);
        pq.offer(new human(0, 0, 0));
        D[0][0] = 0;
        while(!pq.isEmpty()) {
            human cur = pq.poll();
            if(cur.i == n-1 && cur.j == n-1) {
                break;
            } else if(cur.i == n-1 || cur.j == n-1) {
                int idx = 0;
                if(cur.i == n-1) {
                    idx = 1;
                }

                int ni = cur.i + dir[idx][0];
                int nj = cur.j + dir[idx][1];

                int cost = 0;
                if(graph[cur.i][cur.j] <= graph[ni][nj]) {
                    cost = graph[ni][nj] - graph[cur.i][cur.j] + 1;
                }

                if(D[ni][nj] > D[cur.i][cur.j] + cost) {
                    D[ni][nj] = D[cur.i][cur.j] + cost;
                    pq.offer(new human(ni, nj, cur.total + cost));
                }
            } else {
                for (int i = 0; i < dir.length; i++) {
                    int ni = cur.i + dir[i][0];
                    int nj = cur.j + dir[i][1];

                    int cost = 0;
                    if(graph[cur.i][cur.j] <= graph[ni][nj]) {
                        cost = graph[ni][nj] - graph[cur.i][cur.j] + 1;
                    }

                    if(D[ni][nj] > D[cur.i][cur.j] + cost) {
                        D[ni][nj] = D[cur.i][cur.j] + cost;
                        pq.offer(new human(ni, nj, cur.total + cost));
                    }
                }
            }
        }
    }
}
