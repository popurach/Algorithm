package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 다리 만들기
 * 여러 섬으로 이루어진 나라 -> 섬과 섬을 잇는 다리 중 최소 길이 구하기
 *
 * 1. dfs -> 섬을 idx로 구분해줌
 *
 * 2. bfs -> 섬의 범위를 확장 (idx 활용)
 * pq로 섬의 idx가 낮은 섬부터 확장 이동
 * 따라서 graph[][]가 2이상일 떄,
 * 섬의 idx가 graph[][] 보다 크다면 최초 방문이므로 2 * cnt
 * 섬의 idx가 graph[][] 보다 작다면 범위 확장 중 방문이므로 2 * cnt + 1
 * */
public class Baek_2146 {
    static class bridge implements Comparable<bridge>{
        int idx;
        int[] arr;

        public bridge(int idx, int[] arr) {
            this.idx = idx;
            this.arr = arr;
        }

        @Override
        public int compareTo(bridge o) {
            return this.idx - o.idx;
        }

    }
    static int N;
    static int[][] graph, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 각 섬마다 특정 idx 값을 부여
        int idx = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(graph[i][j] == 1) {
                    graph[i][j] = idx;
                    dfs(new int[]{i, j}, idx);
                    idx += 1;
                }
            }
        }
        System.out.println(bfs());
    }
    static void dfs(int[] cur, int idx) {
        for (int i = 0; i < 4; i++) {
            int ni = cur[0] + dir[i][0];
            int nj = cur[1] + dir[i][1];
            if(ni < 0 || nj < 0 || ni > N-1 || nj > N-1 || graph[ni][nj] != 1) {
                continue;
            }
            graph[ni][nj] = idx;
            dfs(new int[]{ni, nj}, idx);
        }
    }
    static int bfs() {
        PriorityQueue<bridge> pq = new PriorityQueue<>();
        Queue<bridge> q = new LinkedList<>();
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(graph[i][j] != 0) {
                    pq.offer(new bridge(graph[i][j], new int[]{i, j}));
                }
            }
        }

        while(!pq.isEmpty()) {
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                bridge cur = pq.poll();
                for (int j = 0; j < 4; j++) {
                    int ni = cur.arr[0] + dir[j][0];
                    int nj = cur.arr[1] + dir[j][1];

                    if(ni < 0 || nj < 0 || ni > N-1 || nj > N-1 || graph[ni][nj] == cur.idx) {
                        continue;
                    }
                    if(graph[ni][nj] == 0) {
                        graph[ni][nj] = cur.idx;
                        q.offer(new bridge(cur.idx, new int[]{ni, nj}));
                    } else {
                        if(graph[ni][nj] > cur.idx) {
                            return cnt * 2;
                        } else {
                            return cnt * 2 + 1;
                        }
                    }
                }
            }
            while(!q.isEmpty()) {
                pq.offer(q.poll());
            }
            cnt += 1;
        }
        return cnt;
    }
}
