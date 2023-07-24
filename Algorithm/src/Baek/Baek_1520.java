package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 내리막 길 
 * dp + dfs 풀이
 * */
public class Baek_1520 {
    static int M, N;
    static int[][] graph, dp, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new int[M][N];
        dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1; // 방뮨 여부 체크를 위해
            }
        }
        System.out.println(dfs(new int[]{0, 0}));
    }
    /**
     * Top-Down 방식 (재귀함수 방식)
     * @param cur 현재 좌표값
     * */
    static int dfs(int[] cur) {
        if(cur[0] == M-1 && cur[1] == N-1) { // 목적지 도달 시 횟수 +1
            return 1;
        }
        if(dp[cur[0]][cur[1]] != -1) {
            return dp[cur[0]][cur[1]];
        }
        dp[cur[0]][cur[1]] = 0; // 방문 처리

        for (int i = 0; i < dir.length; i++) {
            int ni = cur[0] + dir[i][0];
            int nj = cur[1] + dir[i][1];

            if(ni<0 || nj<0 || ni>M-1 || nj>N-1 || graph[cur[0]][cur[1]] <= graph[ni][nj]) {
                continue;
            }
            if(dp[ni][nj] == -1) { // 첫 방문이라면
                dp[cur[0]][cur[1]] += dfs(new int[]{ni, nj});
            } else if(dp[ni][nj] >= 1){ // 방문했었고, 도착할 수 있다면
                dp[cur[0]][cur[1]] += dp[ni][nj];
            }
        }
        return dp[cur[0]][cur[1]];
    }
}
