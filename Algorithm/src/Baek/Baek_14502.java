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
/**
 * 연구소
 * 이차원 배열 조합 -> for(int i=0; i<N*M; i++)로 계산한다
 * 조합 -> bfs -> check
 * */
public class Baek_14502 {
    static int N, M, max = 0;
    static List<int[]> virus;
    static int[][] graph, copy, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        virus = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }
        comb(0, 0);
        System.out.println(max);
    }
    static void comb(int cnt, int start) {
        if(cnt == 3) {
            bfs();
            return;
        }
        for (int c = start; c < N*M; c++) {
            int i = c / M, j = c % M;
            if(graph[i][j] != 0) continue;
            graph[i][j] = 1;
            comb(cnt + 1, c + 1);
            graph[i][j] = 0;
        }
    }
    static void bfs() {
        copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            copy[i] = Arrays.copyOf(graph[i], graph[i].length);
        }

        Queue<int[]> q = new LinkedList<>();
        virus.forEach( v ->
            q.offer(new int[]{v[0], v[1]})
        );
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < dir.length; i++) {
                int ni = cur[0] + dir[i][0];
                int nj = cur[1] + dir[i][1];

                if(ni < 0 || nj < 0 || ni > N-1 || nj > M-1 || copy[ni][nj] != 0) {
                    continue;
                }
                copy[ni][nj] = 2;
                q.offer(new int[]{ni, nj});
            }
        }
        check();
    }
    static void check() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(copy[i][j] == 0) {
                    cnt++;
                }
            }
        }
        max = Math.max(max, cnt);
    }
}
