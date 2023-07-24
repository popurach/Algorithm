package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 파이프 옮기기 1
 * DP -> 현재 위치로 가로, 세로, 대각선으로 올 수 있는 방법
 * */
public class Baek_17070re {
    static int N, cnt = 0;
    static int[][] graph, dir = {{0, 1}, {1, 0}, {1, 1}};
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1][3]; // 0:가로  1:세로  2:대각선
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 현재 파이프 상태 (가로 방향)
        dp[1][2][0] = 1;
        for (int i = 1; i <= N; i++) {
            // j = 3인 이유 : 현재 파이프 위치 상 모두 j>=3
            for (int j = 3; j <= N; j++) {
                if(graph[i][j] == 0) { // 현재 파이프 방향 가로일 때 현재 위치로 올 수 있는 경우
                    dp[i][j][0] += (dp[i][j-1][0] + dp[i][j-1][2]);
                }
                if(i - 1 >= 1 && graph[i][j] == 0) { // 현재 파이프 방향 세로일 때 현재 위치로 올 수 있는 경우
                    dp[i][j][1] += (dp[i-1][j][1] + dp[i-1][j][2]);
                }
                // 현재 파이프 방향 대각선일 때 현재 위치로 올 수 있는 경우
                if(i -1 >= 1 && graph[i][j] == 0 && graph[i-1][j] == 0 && graph[i][j-1] == 0) {
                    dp[i][j][2] += (dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2]);
                }
            }
        }
        System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
    }
}
