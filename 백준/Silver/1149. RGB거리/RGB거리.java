import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * RGB 거리
 * Top-Down 방식 풀이 (재귀함수 사용)
 * Bottom-Up 방식 풀이 (반복문 사용)
 * */
public class Main {
    static int N;
    static int[][] graph;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        graph = new int[N + 1][3];
        dp = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }
        // Bottom-Up 방식 (반복문 사용)
        for (int i = 1; i <= N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1] + graph[i][1], dp[i-1][2] + graph[i][2]);
            dp[i][1] = Math.min(dp[i - 1][0] + graph[i][0], dp[i-1][2] + graph[i][2]);
            dp[i][2] = Math.min(dp[i - 1][0] + graph[i][0], dp[i-1][1] + graph[i][1]);
        }
        System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
//        System.out.println(Math.min(knapsack(0, N), Math.min(knapsack(1, N), knapsack(2, N))));
    }
    /**
     * Top-Down 방식
     * @param num 현재 방문한 집의 색 (빨강, 초록, 파랑)
     * @param n 현재 몇번째 집에 방문했는지
     * */
    static int knapsack(int num, int n) {
        if(dp[n][num] != -1) { // 이미 방문했던 값이라면
            return dp[n][num];
        }
        dp[n][num] = 0; // 방문 처리
        if(num == 0) {
            dp[n][num] = Math.min(knapsack(1, n-1) + graph[n][1], knapsack(2, n-1) + graph[n][2]);
        } else if(num == 1) {
            dp[n][num] = Math.min(knapsack(0, n-1) + graph[n][0], knapsack(2, n-1) + graph[n][2]);
        } else {
            dp[n][num] = Math.min(knapsack(0, n-1) + graph[n][0], knapsack(1, n-1) + graph[n][1]);
        }
        return dp[n][num];
    }
}